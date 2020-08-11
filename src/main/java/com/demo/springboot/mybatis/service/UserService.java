package com.demo.springboot.mybatis.service;

import com.demo.springboot.mybatis.entity.User;

import java.util.List;

public interface UserService {
//    验证密码
    public boolean verify(String userCode,String userPassword);
//    注册
    public void register(User user);
//
    public List<User> searchAll();

}
