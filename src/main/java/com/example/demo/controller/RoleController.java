package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import com.example.demo.utils.PassToken;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PassToken
    @PostMapping(value = "/roles")
    public Object findAll(){
        List<Object> roles = Collections.singletonList(roleService.selectAll());
        return new Message(StatusType.SUCCESS_STATUS,"获取角色列表成功",roles);
    }

}
