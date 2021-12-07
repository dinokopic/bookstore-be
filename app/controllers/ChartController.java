package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.ElasticChartService;

import javax.inject.Inject;
import java.io.IOException;

public class ChartController extends Controller {
    private final ElasticChartService chartService;

    @Inject
    public ChartController(ElasticChartService chartService) {
        this.chartService = chartService;
    }

    public Result byPrice() {
        try {
            return ok(Json.parse(chartService.booksByPrice().toString()));
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("ERROR 400 - Bad Request");
        }
    }

    public Result bestSellingGenres() {
        try {
            return ok(Json.parse(chartService.bestSellingGenres().toString()));
        } catch (IOException exception) {
            exception.printStackTrace();
            return badRequest("ERROR 400 - Bad Request");
        }
    }

    public Result byProfit() throws IOException {
        return ok(Json.parse(chartService.profit().toString()));
    }
}
