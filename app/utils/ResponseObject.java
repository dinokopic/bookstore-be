package utils;

import models.Book;

import java.util.List;

public class ResponseObject {
    private List<Book> books;
    private Long totalHits;

    public ResponseObject(List<Book> books, Long totalHits) {
        this.books = books;
        this.totalHits = totalHits;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Long totalHits) {
        this.totalHits = totalHits;
    }
}
