package com.challenging.dao;

import com.challenging.domain.Admin;
import com.challenging.domain.Customer;

import java.util.List;

public interface AdminDao {

     int updatePassword(Admin admin);

     int insertCustomer(Customer customer);

     int updateCustomer(Customer customer);

     void deleteCustomer(int id);

     List<Customer> queryAllCustomer();

     List<Admin> queryAllAdmin();

     Customer queryCustomerById(int id);

     Admin queryAdminById(int id);

     int updateLoginTime(int id);

     Admin queryByEmail(String email);

     int updateAdmin(Admin admin);
}
