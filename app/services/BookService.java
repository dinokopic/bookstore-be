package services;
import co.elastic.clients.base.RestClientTransport;
import co.elastic.clients.base.Transport;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._core.SearchResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import models.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import play.libs.ws.*;
import utils.QueryBuilder;
import utils.QueryType;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;


public class BookService implements WSBodyReadables, WSBodyWritables {
    private final String BOOKSTORE_URL = "http://localhost:9200/bookstore/_search";
    private final WSClient ws;

    @Inject
    public BookService(WSClient ws) {
        this.ws = ws;
    }

    public CompletionStage<WSResponse> getBooks(String title, String author, String sortByField, String sortOrder) {
        QueryBuilder builder = new QueryBuilder(QueryType.must);
        var request = ws.url(BOOKSTORE_URL);
        request.setBody(
                builder.addField("title", title)
                        .addField("author", author)
                        .sortBy(sortByField, sortOrder)
                        .buildAsJson()
        );
        return request.get();
    }

    private ElasticsearchClient createElasticClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)
        ).build();
        System.out.println(restClient.isRunning());
        Transport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }

    public List<Book> getDirectlyFromElastic() throws IOException {
        SearchResponse<Book> search = createElasticClient().search(s ->
             s.index("bookstore")
                     .query(q -> q
                             .match(m -> m
                                     .field("title")
                                     .query("harry")))
        , Book.class);
        List<Book> books = new ArrayList<>();
        for (var hit: search.hits().hits()) {
            Book book = hit.source();
            book.setId(hit.id());
            books.add(book);
        }
        return books;
    }

    public CompletionStage<WSResponse> getBookById(Long id) {
        QueryBuilder builder = new QueryBuilder(QueryType.must);
        return ws.url(BOOKSTORE_URL)
                .setBody(builder.addField("_id", id.toString()).buildAsJson())
                .get();
    }
/*
    public Book getBookById(Long id) {
        Book book = null;
        return book;
    }

 */
}
