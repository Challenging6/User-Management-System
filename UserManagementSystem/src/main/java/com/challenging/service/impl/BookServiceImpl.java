package com.challenging.service.impl;

import com.challenging.dao.BookDao;
import com.challenging.domain.Book;
import com.challenging.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    public int updateBook(Book book){
        bookDao.updateBookList(book);
        return bookDao.updateBook(book);
    }

    public int insertBook(Book book){
        return bookDao.insertBook(book);
    }

    public void deleteBook(Book book){
        bookDao.deleteBook(book.getBookId());
    }

    public Book queryById(int id){
        return bookDao.queryById(id);
    }

    public List<Book> queryAllBook(){
        return bookDao.queryAllBook();
    }
}

