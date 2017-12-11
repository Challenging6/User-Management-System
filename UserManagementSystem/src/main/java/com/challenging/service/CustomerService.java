package com.challenging.service;

import com.challenging.domain.Book;
import com.challenging.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    int updatePassword(Customer customer);

    Customer queryById(int id);

    Customer queryByEmail(String email);

    int updateLoginTime(int id);

    boolean validateLogin(String email, String password);

    int createNewAccount(Customer customer);

    int updateCustomer(Customer customer);

    List<Book> books(int userId);

    int borrowBook(int bookId, int userId);

    void returnBook(int bookId, int userId);
}
