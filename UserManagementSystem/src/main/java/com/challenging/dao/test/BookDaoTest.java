package com.challenging.dao.test;

import com.challenging.dao.BookDao;
import com.challenging.domain.Book;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDaoTest extends BaseTest{

    @Autowired
    private BookDao bookDao;

    @Test
    public void testUpdateBook() throws Exception{
        Book book = bookDao.queryById(1);
        book.setTitle("spring指南");
        book.setCategory("coding");
        book.setAuthor("shit");
        book.setIsbn("666666666666");
        book.setStoreAmount(100);
        book.setLendingAmount(50);

        bookDao.updateBook(book);
        book = bookDao.queryById(1);
        System.out.println(book);
    }

    @Test
    public void testInsertBook() throws Exception{
        Book book = new Book();
        book.setTitle("java教程");
        book.setCategory("coding");
        book.setAuthor("challenging");
        book.setIsbn("6633123213");
        book.setStoreAmount(10);
        book.setLendingAmount(5);
        bookDao.insertBook(book);
    }

    @Test
    public void testDeleteBook() throws Exception{
        bookDao.deleteBook(1);

    }

    @Test
    public void queryAllBook() throws Exception{
        List<Book> books = bookDao.queryAllBook();
        for(Book book: books){
            System.out.println(book);
        }
    }
}
