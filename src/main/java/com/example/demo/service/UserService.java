package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    //查询所有User
    List<User> selectAll();

    //增加一个User
    int insert(User user);

    //删除一个User
    int delete(String account);

    //查询一个User
    User select(String account);

    //修改一个User
    int update(User user);

}
