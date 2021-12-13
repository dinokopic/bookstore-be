package services;

import api.ElasticApi;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import utils.ElasticAggregationKey;

import javax.inject.Inject;
import java.io.IOException;

public class ElasticChartService {
    private final ElasticApi api;

    @Inject
    public ElasticChartService(ElasticApi api) {
        this.api = api;
    }

    public JsonArray booksByPrice() throws IOException {
        var result = api.getBooksByPrice().aggregations().get(ElasticAggregationKey.booksByPrice.name());
        return result.asJsonObject().get("buckets").asJsonArray();
    }

    public JsonArray bestSellingGenres() throws IOException {
        var result = api.getBestSellingGenres().aggregations().get(ElasticAggregationKey.genres.name());
        return result.asJsonObject().get("buckets").asJsonArray();
    }

    public JsonArray profit() throws IOException {
        var response = api.getProfit().hits().hits();
        var objectBuilder = Json.createObjectBuilder();
        var arrayBuilder = Json.createArrayBuilder();
        for (var hit : response) {
            var book = hit.source();
            objectBuilder.add("title", book.getTitle());
            var profit = hit.fields();
            for (var x : profit.entrySet()) {
                objectBuilder.add(x.getKey(), x.getValue().toJson().asJsonArray().get(0));
            }
            arrayBuilder.add(objectBuilder.build());
        }
        return arrayBuilder.build();
    }

    public JsonArray bestSellingBooks() throws IOException {
        var response = api.getBooks("sold", null, 0, 10).hits().hits();
        var objectBuilder = Json.createObjectBuilder();
        var arrayBuilder = Json.createArrayBuilder();
        for (var hit: response) {
            var book = hit.source();
            objectBuilder.add("title", book.getTitle());
            objectBuilder.add("sold", book.getSold());
            arrayBuilder.add(objectBuilder.build());
        }
        return arrayBuilder.build();
    }
}
