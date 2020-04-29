package com.example.demo.controller;

import com.example.demo.model.Training_Program;
import com.example.demo.model.Score;
import com.example.demo.service.Graduation_RequirementService;
import com.example.demo.service.StudentService;
import com.example.demo.utils.PageList;
import com.example.demo.service.Graduation_AuditService;
import com.example.demo.service.ScoreService;
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
    public Object fetchList(String studentId,String college, int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(!studentId.equals("")){
            lists = Collections.singletonList(graduation_auditService.selectBysId(studentId));
        }
        else if(!college.equals("")){
            lists = Collections.singletonList(graduation_auditService.selectBycollege(college));
        }
        else {
            lists = Collections.singletonList(graduation_auditService.LimitedSelectAll(start,limit));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }


}
