package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.model.PageList;
import com.example.demo.model.Replacement;
import com.example.demo.service.ReplacementService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/replacement")
public class ReplacementController {

    @Autowired
    ReplacementService replacementService;

    @GetMapping("/list")
    public Object fetchList(String studentId, int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(replacementService.selectAll(start,limit));
        }
        else {
            lists = Collections.singletonList(replacementService.selectBystudentId(studentId,start,limit));
        }

        int total=lists.size();
        return new PageList(StatusType.SUCCESS_STATUS,total,lists);
    }

    @GetMapping("/detail")
    public Object fetchReplacement(int replacementId){
        List<Object> lists = Collections.singletonList(replacementService.selectByreplacementId(replacementId));

        return new Message(StatusType.SUCCESS_STATUS,"获取详情成功",lists);
    }

    @PostMapping("/create")
    public Object createReplacement(String studentId,
                                    String original_course, Double original_course_credit,
                                    String replacement_course_a, Double replacement_course_a_credit,
                                    String replacement_course_b, Double replacement_course_b_credit,
                                    String replacement_course_c, Double replacement_course_c_credit,
                                    String report_time, String audit_result){

        Replacement replacement = new Replacement(0,studentId,
                original_course,original_course_credit,
                replacement_course_a,replacement_course_a_credit,
                replacement_course_b,replacement_course_b_credit,
                replacement_course_c,replacement_course_c_credit,
                report_time,audit_result);
        try {
            int result = replacementService.insert(replacement);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
    }

    @PostMapping("/update")
    public Object updateReplacement(int replacementId, String studentId,
                                    String original_course, Double original_course_credit,
                                    String replacement_course_a, Double replacement_course_a_credit,
                                    String replacement_course_b, Double replacement_course_b_credit,
                                    String replacement_course_c, Double replacement_course_c_credit,
                                    String report_time, String audit_result){

        Replacement replacement = new Replacement(replacementId,studentId,
                original_course,original_course_credit,
                replacement_course_a,replacement_course_a_credit,
                replacement_course_b,replacement_course_b_credit,
                replacement_course_c,replacement_course_c_credit,
                report_time,audit_result);
        try{
            int result = replacementService.update(replacement);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"更新失败");
    }

}
