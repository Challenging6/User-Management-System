package com.challenging.service.impl;

import com.challenging.dao.BookDao;
import com.challenging.dao.CustomerDao;
import com.challenging.domain.Book;
import com.challenging.domain.Customer;
import com.challenging.service.CustomerService;
import com.challenging.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public int updatePassword(Customer customer) {
        customer.setPassword(new String(Encrypt.encryptBASE64(customer.getPassword().getBytes())));
        return customerDao.updatePassword(customer);
    }

    @Override
    public Customer queryById(int id) {
        return customerDao.queryById(id);
    }

    @Override
    public Customer queryByEmail(String email){
        return customerDao.queryByEmail(email);
    }

    @Override
    public int updateLoginTime(int id) {
        return customerDao.updateLoginTime(id);
    }

    @Override
    public boolean validateLogin(String email, String password) {
        try {
            Customer customer = customerDao.queryByEmail(email);
            String passwordEncode = new String(Encrypt.encryptBASE64(password.getBytes()));
            if(Objects.equals(customer.getPassword(), passwordEncode)){
                customerDao.updateLoginTime(customer.getId());
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public int createNewAccount(Customer customer){
        try {

            customer.setPassword(new String(Encrypt.encryptBASE64(customer.getPassword().getBytes())));

            customerDao.createNewAccount(customer);
            return 1;

        }
        catch (Exception e){
            System.out.println(e.toString());
            return 0;
        }
    }

    @Override
    public int updateCustomer(Customer customer){
        return customerDao.updateCustomer(customer);
    }


    @Override
    public List<Book> books(int userId){
        return customerDao.books(userId);
    }

    @Override
    public int  borrowBook(int bookId, int userId){
        Book book = bookDao.queryById(bookId);
        List<Book> borrowedBooks =  customerDao.books(userId);
        for (Book book1:borrowedBooks){
            if (book.getBookId() == book1.getBookId()){
                return 0;
            }
        }
        if (book.getStoreAmount()> book.getLendingAmount()) {
            customerDao.borrowBook(book, userId);
            book.setLendingAmount(book.getLendingAmount()+1);
            bookDao.updateBook(book);
            return 1;
        }
        else
            return 2;
    }

    @Override
    public void returnBook(int bookId, int userId){
        Book book = bookDao.queryById(bookId);
        book.setLendingAmount(book.getLendingAmount()-1);
        customerDao.returnBook(book, userId);
    }
}