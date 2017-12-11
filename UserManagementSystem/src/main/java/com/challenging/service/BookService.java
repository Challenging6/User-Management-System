package com.challenging.service;

import com.challenging.domain.Book;

import java.util.List;

public interface BookService {
    int updateBook(Book book);
    void deleteBook(Book book);
    int insertBook(Book book);
    Book queryById(int id);
    List<Book> queryAllBook();
}
