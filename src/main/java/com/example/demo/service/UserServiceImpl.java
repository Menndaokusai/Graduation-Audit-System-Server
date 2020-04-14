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
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(String account) {
        return userMapper.delete(account);
    }

    @Override
    public User select(String account) {
        return userMapper.select(account);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}
