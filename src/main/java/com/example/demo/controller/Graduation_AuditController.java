package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.Graduation_AuditService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class Graduation_AuditController {

    @Autowired
    Graduation_AuditService graduation_auditService;

    @GetMapping("/list")
    public Object fetchList(){
        List<Object> lists = Collections.singletonList(graduation_auditService.selectAll());

        return new Message(StatusType.SUCCESS_STATUS,"获取列表成功",lists);
    }

}
