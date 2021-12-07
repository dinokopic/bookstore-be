package services;
import api.ElasticApi;
import co.elastic.clients.elasticsearch._core.SearchResponse;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import models.Book;
import utils.ElasticAggregationKey;
import utils.FilterType;
import utils.ResponseObject;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ElasticService {
    private final ElasticApi api;

    @Inject
    public ElasticService(ElasticApi api) {
        this.api = api;
    }

    public Book getBookById(String id) throws IOException {
        Book book = null;
        var response = api.getBookById(id);
        for (var hit: response.hits().hits()) {
            book = hit.source();
            book.setId(hit.id());
        }
        return book;
    }

    private List<Book> extractBooksFromResponse(SearchResponse<Book> response) {
        List<Book> books = new ArrayList<>();
        for (var hit: response.hits().hits()) {
            Book book = hit.source();
            book.setId(hit.id());
            books.add(book);
        }
        return books;
    }

    public List<Book> getBooks(String sortBy, String order) throws IOException {
        return extractBooksFromResponse(api.getBooks(sortBy, order, null, null));
    }

    public List<Book> searchBooks(String title, String author, String genre, String numberOfAwards) throws IOException {
        return extractBooksFromResponse(api.searchBooks(title, author, genre, numberOfAwards));
    }

    private JsonArray extractFilters(SearchResponse<Book> response, ElasticAggregationKey aggregationKey) {
        var aggregation = response.aggregations().get(aggregationKey.name());
        return aggregation.asJsonObject().get("buckets").asJsonArray();
    }

    public ResponseObject getPopularBooks(Integer page, Integer size) throws IOException {
        var response = api.getBooks("sold", null, page, size);
        List<Book> books = extractBooksFromResponse(response);
        Long numberOfHits = response.hits().total().value();
        return new ResponseObject(books, numberOfHits);
    }

    public ResponseObject getLatestBooks(Integer page, Integer size) throws IOException {
        var response = api.getBooks("year.keyword", null, page, size);
        List<Book> books = extractBooksFromResponse(response);
        Long numberOfHits = response.hits().total().value();
        return new ResponseObject(books, numberOfHits);
    }

    public JsonArray updateFilter(String type, String title, String author, String genre, String numberOfAwards) throws IOException {
        try {
            var filter = FilterType.valueOf(type);
            switch (FilterType.valueOf(type)) {
                case author:
                    return extractFilters(api.getAuthors(title, genre, numberOfAwards), ElasticAggregationKey.authors);
                case genre:
                    return extractFilters(api.getGenres(title, author, numberOfAwards), ElasticAggregationKey.genres);
                case numberOfAwards:
                    return extractFilters(api.getAwardsCount(title, author, genre), ElasticAggregationKey.awardsCount);
                default:
                    return null;
            }
        } catch (Exception ignore) {
            return null;
        }
    }
}
