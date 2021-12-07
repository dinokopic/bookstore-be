package models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String pages, year, author, title, id, img_url;
    private List<String> awards, genre, category;
    private int sold, price, number_of_pages;

    public Book() {
        pages = year = author = title = img_url = "";
        awards = new ArrayList<>();
        genre = new ArrayList<>();
        category = new ArrayList<>();
        sold = price = number_of_pages = -1;
    }

    public Book(String year, String author, String title, List<String> awards, List<String> genre, List<String> category, int sold, int price, int number_of_pages, String img_url) {
        this.year = year;
        this.author = author;
        this.title = title;
        this.awards = awards;
        this.genre = genre;
        this.category = category;
        this.sold = sold;
        this.price = price;
        this.number_of_pages = number_of_pages;
        this.img_url = img_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
