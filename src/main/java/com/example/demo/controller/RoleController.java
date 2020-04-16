package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.RoleService;
import com.example.demo.utils.PassToken;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PassToken
    @PostMapping(value = "/list")
    public Object findAll(){
        List<Object> lists = Collections.singletonList(roleService.selectAll());
        return new Message(StatusType.SUCCESS_STATUS,"获取列表成功",lists);
    }

}
