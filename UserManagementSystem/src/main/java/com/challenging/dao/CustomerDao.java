package com.challenging.dao;

import com.challenging.domain.Book;
import com.challenging.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    int updatePassword(Customer customer);
    Customer queryById(int id);
    int updateCustomer(Customer customer);
    int updateLoginTime(int id);
    Customer queryByEmail(String email);
    int createNewAccount(Customer customer);
    List<Book> books(int userId);
    int borrowBook(@Param("book") Book book, @Param("userId") int userId);
    void returnBook(@Param("book") Book book, @Param("userId") int userId);

}
