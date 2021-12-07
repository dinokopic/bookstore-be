package api;

import co.elastic.clients.base.RestClientTransport;
import co.elastic.clients.base.Transport;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._core.SearchResponse;
import co.elastic.clients.elasticsearch._types.mapping.RuntimeFieldType;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import jakarta.json.Json;
import models.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import utils.ElasticAggregationKey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ElasticApi {
    private final ElasticsearchClient elasticClient;
    private final String INDEX_NAME = "bookstore";

    public ElasticApi() {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)
        ).build();
        Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        elasticClient = new ElasticsearchClient(transport);
    }

    public SearchResponse<Book> getBooks(String sortBy, String order, Integer page, Integer size) throws IOException {
        if (sortBy == null) {
            sortBy = "sold";
        }
        if (order == null) {
            order = "desc";
        }
        String finalSortBy = sortBy;
        String finalOrder = order;
        Integer from = page * size;

        return elasticClient.search(s -> s
                .index(INDEX_NAME)
                .from(from)
                .size(size)
                .sort(Json.createObjectBuilder()
                                .add(finalSortBy, finalOrder)
                                .build()
                ), Book.class
        );
    }

    public SearchResponse<Book> getBookById(String id) throws IOException {
        return elasticClient.search(s ->
                s.index(INDEX_NAME)
                        .query(q -> q
                                .match(m -> m
                                        .field("_id")
                                        .query(id)
                                )
                        ), Book.class
        );
    }

    private Query buildMultiMatchQuery(String fieldName, String fieldValue, TextQueryType queryType) {
        return new Query.Builder()
                .multiMatch(m -> m
                        .addFields(fieldName)
                        .query(fieldValue)
                        .type(queryType)
                ).build();
    }

    private Query buildMatchQuery(String fieldName, String fieldValue) {
        return new Query.Builder()
                .match(m -> m
                        .field(fieldName)
                        .query(fieldValue)
                ).build();
    }

    private List<Query> getQueryList(String title, String author, String genre, String numberOfAwards) {
        Query scriptQuery = new Query.Builder()
                .script(s -> s
                        .script(Json.createObjectBuilder()
                                .add("inline", "doc['awards.keyword'].length == " + numberOfAwards)
                                .build()
                        )
                ).build();
        List<Query> queries = new ArrayList<>();
        if (title != null) {
            queries.add(buildMultiMatchQuery("title", title, TextQueryType.PhrasePrefix));
        }
        if (author != null) {
            queries.add(buildMultiMatchQuery("author", author, TextQueryType.Phrase));
        }
        if (genre != null) {
            queries.add(buildMatchQuery("genre", genre));
        }
        if (numberOfAwards != null) {
            queries.add(scriptQuery);
        }
        return queries;
    }

    public SearchResponse<Book> searchBooks(String title, String author, String genre, String numberOfAwards, Integer page, Integer size) throws IOException {
        return elasticClient.search(s -> s
                .index(INDEX_NAME)
                .from(page * size)
                .size(size)
                .query(q -> q
                        .bool(b -> b
                                .must(getQueryList(title, author, genre, numberOfAwards))
                        )
                ).aggs("price", a -> a
                        .terms(t -> t
                                .field("price")
                        )
                ), Book.class
        );
    }

    public SearchResponse<Book> aggregateSearch(String title, String author, String genre, String numberOfAwards,
                                                ElasticAggregationKey aggregationKey, String aggregationField) throws IOException {
        return elasticClient.search(s -> s
                .index(INDEX_NAME)
                .size(0)
                .query(q -> q
                        .bool(b -> b
                                .must(getQueryList(title, author, genre, numberOfAwards))
                        )
                ).aggs(aggregationKey.name(), a -> a
                        .terms(t -> t
                                .field(aggregationField)
                        )
                ), Book.class
        );
    }

    public SearchResponse<Book> getGenres(String title, String author, String numberOfAwards) throws IOException {
        return aggregateSearch(title, author, null, numberOfAwards, ElasticAggregationKey.genres, "genre.keyword");
    }

    public SearchResponse<Book> getAuthors(String title, String genre, String numberOfAwards) throws IOException {
        return aggregateSearch(title, null, genre, numberOfAwards, ElasticAggregationKey.authors, "author.keyword");
    }

    public SearchResponse<Book> getAwardsCount(String title, String author, String genre) throws IOException {
        return elasticClient.search(s -> s
                .index(INDEX_NAME)
                .size(0)
                .query(q -> q
                        .bool(b -> b
                                .must(getQueryList(title, author, genre, null))
                        )
                ).aggs(ElasticAggregationKey.awardsCount.name(), a -> a
                        .terms(t -> t
                                .script(Json.createObjectBuilder()
                                        .add("inline", "doc['awards.keyword'].length")
                                        .build()
                                )
                        )
                ), Book.class
        );
    }

    public SearchResponse<Book> getBooksByPrice() throws IOException {
        return elasticClient.search(s -> s
                .index(INDEX_NAME)
                .size(0)
                .aggs(ElasticAggregationKey.booksByPrice.name(), a -> a
                        .terms(t -> t
                                .field("price")
                        )
                ), Book.class
        );
    }

    public SearchResponse<Book> getBestSellingGenres() throws IOException {
        return elasticClient.search(s -> s
                .index(INDEX_NAME)
                .size(0)
                .aggs(ElasticAggregationKey.genres.name(), a -> a
                        .terms(t -> t
                                .field("genre.keyword")
                        ).aggs(ElasticAggregationKey.soldByGenre.name(), a1 -> a1
                                .sum(sum -> sum
                                        .field("sold")
                                )
                        )
                ), Book.class);
    }

    public SearchResponse<Book> getProfit() throws IOException {
        var array = Json.createArrayBuilder().add("profit").build();
        return elasticClient.search(s -> s
                .index(INDEX_NAME)
                .runtimeMappings("profit", m -> m
                        .type(RuntimeFieldType.Long)
                        .script(Json.createObjectBuilder()
                                .add("inline", "emit(doc['sold'].value * doc['price'].value)")
                                .build()
                        )
                ).sort(Json.createObjectBuilder()
                        .add("profit", "desc")
                        .build()
                ).fields(Json.createArrayBuilder().add("profit").build()), Book.class);
    }
}
