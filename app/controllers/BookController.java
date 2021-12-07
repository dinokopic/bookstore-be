package controllers;

import jakarta.json.JsonArray;
import models.Book;
import play.libs.Json;
import play.mvc.*;
import services.BookService;
import services.ElasticService;
import utils.ResponseObject;
import java.lang.Long;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class BookController extends Controller {

    private final BookService bs;
    private final ElasticService elasticService;

    @Inject
    public BookController(BookService bs, ElasticService elasticService) {
        this.bs = bs;
        this.elasticService = elasticService;
    }

    /*
    extract source
     */

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }

    public Result books(String sortBy, String order) {
        try {
            List<Book> books = elasticService.getBooks(sortBy, order);
            return ok(Json.toJson(books));
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("ERROR 400 - Bad Request: The parameters You sent are not valid!");
        }
    }

    public Result getBookById(String id) {
        try {
            Book book = elasticService.getBookById(id);
            if (book == null) {
                return ok("ERROR 404 - Not Found: Book with selected index does not exist!");
            }
            return ok(Json.toJson(book));
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("ERROR 400 - Bad Request");
        }
    }

    public Result search(String title, String author, String genre, String numberOfAwards, Integer page, Integer size) {
        try {
            ResponseObject books = elasticService.searchBooks(title, author, genre, numberOfAwards, page, size);
            return ok(Json.toJson(books));
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("ERROR 400 - Bad Request");
        }
    }

    public Result popular(Integer page, Integer size) {
        try {
            ResponseObject books = elasticService.getPopularBooks(page, size);
            return ok(Json.toJson(books));
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("ERROR 400 - Bad Request");
        }
    }

    public Result latest(Integer page, Integer size) {
        try {
            ResponseObject books = elasticService.getLatestBooks(page, size);
            return ok(Json.toJson(books));
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("ERROR 400 - Bad Request");
        }
    }

    public Result getFilters(String type, String title, String author, String genre, String numberOfAwards) {
        try {
            JsonArray result = elasticService.updateFilter(type, title, author, genre, numberOfAwards);
            if (result == null) {
                return badRequest("ERROR 400 - Filter of type '" + type + "' does not exist.");
            } else {
                return ok(Json.parse(result.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("ERROR 400 - Bad Request");
        }
    }

}
