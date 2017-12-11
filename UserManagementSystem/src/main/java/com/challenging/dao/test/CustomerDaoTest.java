package com.challenging.dao.test;

import java.util.List;

import com.challenging.domain.Book;
import com.challenging.domain.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.challenging.dao.CustomerDao;

public class CustomerDaoTest extends BaseTest{

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testQueryById() throws Exception {
        int id = 1;
        Customer customer = customerDao.queryById(id);
        System.out.println(customer);
    }

    @Test
    public void testUpdatePassword()throws Exception{
        int id = 1;
        Customer customer = customerDao.queryById(id);
        customer.setPassword("992871471");
        System.out.println(customer);
        customerDao.updatePassword(customer);
    }
    @Test
    public void testUpdateCustomer()throws Exception{
        int id = 1;
        Customer customer = customerDao.queryById(id);
        customer.setUsername("superChallenging");
        customer.setAge(7);
        customer.setGender("女");
        customerDao.updateCustomer(customer);
    }

    @Test
    public void testUpdateLoginTime()throws Exception{
        int id = 1;
        customerDao.updateLoginTime(id);
    }

    @Test
    public void testQueryByEmail() throws Exception {
        String email  = "13233211@qq.com";
        Customer customer = customerDao.queryByEmail(email);
        System.out.println(customer);
    }

    @Test
    public void testCreateNewAccount() throws Exception{
        Customer customer = new Customer();
        customer.setUsername("fdsf");
        customer.setNickname("fs");
        customer.setPassword("123456");
        customer.setGender("男");
        customer.setAge(12);
        customer.setEmail("992871471@qq.com");
        customer.setPhone("13123421412");
        customerDao.createNewAccount(customer);
    }

    @Test
    public void testBooks() throws Exception{
        List<Book> books = customerDao.books(1);
        for(Book book: books)
            System.out.println(book);
    }

    @Test
    public void testBorrowBook() throws Exception{
        Book book = new Book();
        book.setBookId(3);
        book.setTitle("九州");
        book.setCategory("玄幻");
        book.setAuthor("江南");
        book.setIsbn("666666666666");
        customerDao.borrowBook(book, 2);

    }

    @Test
    public void testReturnBook() throws Exception{
        Book book = new Book();
        book.setBookId(3);
        book.setTitle("spring指南");
        book.setCategory("coding");
        book.setAuthor("shit");
        book.setIsbn("666666666666");
        customerDao.returnBook(book, 1);
    }

}
