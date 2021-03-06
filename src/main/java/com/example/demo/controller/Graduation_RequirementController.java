package com.example.demo.controller;

import com.example.demo.model.Graduation_Requirement;
import com.example.demo.utils.*;
import com.example.demo.service.Graduation_RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/requirement")
public class Graduation_RequirementController {


    @Autowired
    Graduation_RequirementService graduation_requirementService;


    @GetMapping("/list")
    public Object fetchList(String enrollment_year,int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(!enrollment_year.equals("")){
            lists = Collections.singletonList(graduation_requirementService.selectByYear(enrollment_year,start,limit));
        }
        else {
            lists = Collections.singletonList(graduation_requirementService.selectAll(start,limit));
        }

        int total = graduation_requirementService.selectCount();

        return new PageList(StatusType.SUCCESS_STATUS,lists,total);
    }


    @PostMapping("/update")
    public Object updateRequirement(@RequestBody Graduation_Requirement graduation_requirement){
        try{
            int result = graduation_requirementService.update(graduation_requirement);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"更新失败");
    }

}
