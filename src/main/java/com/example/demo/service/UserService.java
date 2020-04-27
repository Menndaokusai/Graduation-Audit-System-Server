package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    //查询所有User
    List<User> selectAll(int start,int limit);

    //增加一个User
    int insert(User user);

    //删除一个User
    int delete(String username);

    //查询一个User
    User select(String username);

    //修改一个User
    int update(User user);

    //修改一个UserRole
    int updateRole(User user);

}
