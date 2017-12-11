package com.challenging.service.impl;

import com.challenging.dao.AdminDao;
import com.challenging.domain.Admin;
import com.challenging.domain.Customer;
import com.challenging.service.AdminService;
import com.challenging.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public int updatePassword(Admin admin){
        admin.setPassword(new String(Encrypt.encryptBASE64(admin.getPassword().getBytes())));
        return adminDao.updatePassword(admin);
    }

    @Override
    public int insertCustomer(Customer customer){
        return adminDao.insertCustomer(customer);
    }

    @Override
    public int updateCustomer(Customer customer){
        return adminDao.updateCustomer(customer);
    }

    @Override
    public int updateAdmin(Admin admin){
        return adminDao.updateAdmin(admin);
    }

    @Override
    public void deleteCustomer(int id){
        adminDao.deleteCustomer(id);
    }

    @Override
    public List<Customer> queryAllCustomer(){
        return adminDao.queryAllCustomer();
    }

    @Override
    public List<Admin> queryAllAdmin(){
        return adminDao.queryAllAdmin();
    }

    @Override
    public Customer queryCustomerById(int id){
        return adminDao.queryCustomerById(id);
    }

    @Override
    public Admin queryAdminById(int id){
        return adminDao.queryAdminById(id);
    }

    @Override
    public int updateLoginTime(int id){
        return adminDao.updateLoginTime(id);
    }

    @Override
    public boolean validateLogin(String email, String password) {
        try {
            Admin admin = adminDao.queryByEmail(email);
            String passwordEncode = new String(Encrypt.encryptBASE64(password.getBytes()));
            if(Objects.equals(admin.getPassword(), passwordEncode)){
                adminDao.updateLoginTime(admin.getId());
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public Admin queryByEmail(String email) {
        return adminDao.queryByEmail(email);
    }

}
