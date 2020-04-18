package com.example.demo.service;


import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll(int start,int limit) {
        return userMapper.selectAll(start, limit);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(String username) {
        return userMapper.delete(username);
    }

    @Override
    public User select(String username) {
        return userMapper.select(username);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int updateRole(User user) {
        return userMapper.updateRole(user);
    }
}
