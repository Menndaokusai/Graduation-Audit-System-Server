package com.example.demo.controller;

import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Message;
import com.example.demo.model.PageList;
import com.example.demo.model.Score;
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
    ScoreService scoreService;

    @GetMapping("/list")
    public Object fetchList(String studentId, int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(graduation_auditService.selectAll(start,limit));
        }
        else {
            lists = Collections.singletonList(graduation_auditService.selectBysId(studentId,start,limit));
        }
        int total = lists.size();
        return new PageList(StatusType.SUCCESS_STATUS,total,lists);
    }

    @GetMapping("/update")
    public Object updateList(){
//        //获取毕业审核表的所有数据
//        List<Graduation_Audit> graduation_audit_list = graduation_auditService.selectAll(0,-1);
//        for (Graduation_Audit g :graduation_audit_list) {
//            //根据毕业审核表中的学号查找学生的成绩
//            List<Score> scores = scoreService.selectBystudentId(g.getStudentId());
//        }

        return new Message(StatusType.SUCCESS_STATUS,"更新成功");
    }


}
