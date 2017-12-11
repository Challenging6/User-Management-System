package com.challenging.domain;

import com.challenging.utils.Encrypt;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Admin {
    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nickname;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String phone;

    @NotNull
    private Integer age;
    private String gender;
    private Date loginTime;
    private Date lastLoginTime;
    private Date createTime;
   // private String headIcon;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public void setHeadIcon(String headIcon) {
//        this.headIcon = headIcon;
//    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

//    public String getHeadIcon() {
//        return headIcon;
//    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Customer{"+
                "id="+id+
                ", username="+username+
                ", password="+password+
                ", nickname="+nickname+
                ", email="+email+
                ", gender="+gender+
                ", age="+age+
                ", phone="+phone+
                ", createTime="+createTime+
                ", loginTime="+loginTime+
                ", lastLoginTime"+lastLoginTime+
                "}";
    }
}
