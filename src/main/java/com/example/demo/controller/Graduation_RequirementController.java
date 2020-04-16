package com.example.demo.controller;

import com.example.demo.model.Graduation_Requirement;
import com.example.demo.model.Message;
import com.example.demo.model.Replacement;
import com.example.demo.service.Graduation_RequirementService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/requirement")
public class Graduation_RequirementController {


    @Autowired
    Graduation_RequirementService graduation_requirementService;

    @GetMapping("/list")
    public Object fetchList(){
        List<Object> lists = Collections.singletonList(graduation_requirementService.selectAll());

        return new Message(StatusType.SUCCESS_STATUS,"获取列表成功",lists);
    }


    @GetMapping("/detail")
    public Object fetchRequirement(int requirementId){
        List<Object> lists = Collections.singletonList(graduation_requirementService.select(requirementId));

        return new Message(StatusType.SUCCESS_STATUS,"获取详情成功",lists);
    }

    @PostMapping("/delete")
    public Object delete(int requirementId){

        try {
            int result = graduation_requirementService.delete(requirementId);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"删除失败");
    }

    @PostMapping("/create")
    public Object createRequirement(String enrollment_year,
                                    String major, String system,
                                    String accum_credit, String average_score,
                                    String relearn_time, String punishment_time,
                                    String update_time){

        Graduation_Requirement graduation_requirement = new Graduation_Requirement(0,enrollment_year,
                major,system, accum_credit,average_score,
                relearn_time,punishment_time, update_time);
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
    public Object updateRequirement(int requirementId, String enrollment_year,
                                    String major, String system,
                                    String accum_credit, String average_score,
                                    String relearn_time, String punishment_time,
                                    String update_time){

        Graduation_Requirement graduation_requirement = new Graduation_Requirement(requirementId,enrollment_year,
                                                                                    major,system, accum_credit,average_score,
                                                                                    relearn_time,punishment_time, update_time);
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
