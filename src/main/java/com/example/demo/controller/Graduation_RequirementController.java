package com.example.demo.controller;

import com.example.demo.model.Graduation_Requirement;
import com.example.demo.utils.Message;
import com.example.demo.utils.PageList;
import com.example.demo.service.Graduation_RequirementService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.StatusType;
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
        if(enrollment_year==null||enrollment_year.equals("")){
            lists = Collections.singletonList(graduation_requirementService.selectAll(start,limit));
        }
        else {
            lists = Collections.singletonList(graduation_requirementService.selectByYear(enrollment_year,start,limit));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }


    @GetMapping("/detail")
    public Object fetchRequirement(int requirementId){
        List<Object> lists = Collections.singletonList(graduation_requirementService.select(requirementId));

        return new Message(StatusType.SUCCESS_STATUS,"获取详情成功",lists);
    }

    @PostMapping("/delete")
    public Object delete(@RequestBody Graduation_Requirement graduation_requirement){

        try {
            int result = graduation_requirementService.delete(graduation_requirement.getRequirementId());
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"删除失败");
    }

    @PostMapping("/create")
    public Object createRequirement(@RequestBody Graduation_Requirement graduation_requirement){

        graduation_requirement.setRequirementId(0);
        graduation_requirement.setUpdate_time(DateUtils.getDate());
        try{
            int result = graduation_requirementService.insert(graduation_requirement);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
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
