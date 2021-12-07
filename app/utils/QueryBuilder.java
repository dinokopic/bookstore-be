package utils;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

public class QueryBuilder {
    private String query;
    private String sort;

    public QueryBuilder(QueryType type) {
        query = "\"query\":{\"bool\":{\"" + type.name() + "\":[";
        sort = "\"sort\":[";
    }

    public QueryBuilder addField(String fieldName, String fieldValue) {
        if (fieldValue != null) {
            if (query.endsWith("}")) {
                query += ",";
            }
            query += "{\"match\":{\"" + fieldName + "\":\"" + fieldValue + "\"}}";
        }
        return this;
    }

    public QueryBuilder sortBy(String fieldName, String sortOrder) {
        if (fieldName != null && sortOrder != null) {
            if (sort.endsWith("}")) {
                sort += ",";
            }
            sort += "{\"" + fieldName + "\":\"" + sortOrder + "\"}";
        }
        return this;
    }

    public String buildAsString() {
        if (!query.endsWith("]}}")) {
            query += "]}}";
        }
        if (!sort.endsWith("]")) {
            sort += "]";
        }
        return "{" + query + "," + sort + "}";
    }

    public JsonNode buildAsJson() {
        return Json.parse(buildAsString());
    }
}
