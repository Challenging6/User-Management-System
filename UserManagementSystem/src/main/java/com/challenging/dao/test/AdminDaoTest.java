package com.challenging.dao.test;

import java.util.List;

import com.challenging.dao.CustomerDao;
import com.challenging.domain.Admin;
import com.challenging.domain.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.challenging.dao.AdminDao;



public class AdminDaoTest extends BaseTest{

    @Autowired
    private AdminDao adminDao;


    @Test
    public void testQueryCustomerById() throws Exception {
        int id = 1;
        Customer customer = adminDao.queryCustomerById(id);
        System.out.println(customer);
    }

    @Test
    public void testQueryAdminById() throws Exception {
        int id = 1;
        Admin admin = adminDao.queryAdminById(id);
        System.out.println(admin);
    }

    @Test
    public void testUpdatePassword()throws Exception{
        int id = 1;
        Admin admin = adminDao.queryAdminById(id);
        admin.setPassword("992871471");
        adminDao.updatePassword(admin);
    }

    @Test
    public void testUpdateCustomer()throws Exception{
        int id = 1;
        Customer customer = adminDao.queryCustomerById(id);
        customer.setNickname("supertertwerChallenging");
        customer.setAge(7);
        customer.setGender("女");
        adminDao.updateCustomer(customer);
    }

    @Test
    public void testUpdateLoginTime()throws Exception{
        int id = 1;
        adminDao.updateLoginTime(id);
    }

    @Test
    public void testInsertCustomer(){
        int id = 2;
        Customer customer = adminDao.queryCustomerById(id);
        customer.setUsername("fdsfds");
        customer.setPassword("13123213");
        adminDao.insertCustomer(customer);
    }

    @Test
    public void testDeleteCustomer(){
        int id = 3;
        adminDao.deleteCustomer(id);
    }

    @Test
    public void testQueryAllCustomer(){
        List<Customer> list = adminDao.queryAllCustomer();
        for(Customer customer : list){
            System.out.println(customer);
        }
    }

    @Test
    public void testQueryAllAdmin(){
        List<Admin> list = adminDao.queryAllAdmin();
        for(Admin admin : list){
            System.out.println(admin);
        }
    }


}
