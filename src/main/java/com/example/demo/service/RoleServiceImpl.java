package com.example.demo.service;

import com.example.demo.mapper.RoleMapper;
import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }
}
