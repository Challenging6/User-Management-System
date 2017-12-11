package com.challenging.domain;


import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Book {
    private int bookId;
    @NotEmpty
    private String isbn;
    @NotEmpty
    private String title;
    @NotEmpty
    private String category;
    @NotEmpty
    private String author;
    @NotNull
    @Min(1)
    private int storeAmount;
    @Min(0)
    private int lendingAmount;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLendingAmount() {
        return lendingAmount;
    }

    public void setLendingAmount(int lendingAmount) {
        this.lendingAmount = lendingAmount;
    }

    public int getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(int storeAmount) {
        this.storeAmount = storeAmount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return title + " " + isbn + " " + bookId + " " + author+" " + storeAmount+" "+lendingAmount ;
    }
}
