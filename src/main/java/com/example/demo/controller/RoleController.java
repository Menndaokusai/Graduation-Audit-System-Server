package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roles")
    public String findAll(){
        List<Role> roles = roleService.selectAll();
        roles.forEach(System.out::println);
        return roles.toString()+"";
    }

}
