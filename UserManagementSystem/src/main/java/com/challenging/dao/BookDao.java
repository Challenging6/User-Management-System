package com.challenging.dao;

import com.challenging.domain.Book;

import java.util.List;

public interface BookDao {
    int updateBook(Book book);
    int insertBook(Book book);
    void deleteBook(int id);
    Book queryById(int id);
    List<Book> queryAllBook();
    int updateBookList(Book book);
}
