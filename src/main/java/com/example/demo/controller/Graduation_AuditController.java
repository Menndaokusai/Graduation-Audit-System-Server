package com.example.demo.controller;

import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Graduation_Requirement;
import com.example.demo.model.Student;
import com.example.demo.service.Graduation_RequirementService;
import com.example.demo.service.StudentService;
import com.example.demo.utils.Message;
import com.example.demo.utils.PageList;
import com.example.demo.service.Graduation_AuditService;
import com.example.demo.service.ScoreService;
import com.example.demo.utils.StatusType;
import com.nimbusds.jose.Requirement;
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
    @Autowired
    StudentService studentService;
    @Autowired
    Graduation_RequirementService graduation_requirementService;

    @GetMapping("/list")
    public Object fetchList(String studentId, int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(graduation_auditService.LimitedSelectAll(start,limit));
        }
        else {
            lists = Collections.singletonList(graduation_auditService.selectBysId(studentId));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }

    @GetMapping("/doaudit")
    public Object doAudit(){
        try {
            //获取审核表中的数据
            List<Graduation_Audit> graduation_audits = graduation_auditService.selectAll();
            for (Graduation_Audit g: graduation_audits) {
                //依据学号查找对应的学生信息
                Student student = studentService.selectBysId(g.getStudentId());
                //依据专业、入学年份、学制查询对应的审核需求
                Graduation_Requirement graduation_requirement = graduation_requirementService
                        .find(student.getMajor(),student.getEnrollment_year(),student.getSystem());
                //依据对应的审核需求设置毕业证书与学位证书
                if(g.getAccum_credit()>=graduation_requirement.getAccum_credit()){
                    //总学分符合毕业需求学分则授予毕业证书
                    g.setGraduation("1");
                    graduation_auditService.updateCertificate(g.getStudentId(),g.getGraduation(),g.getDegree());
                }
                if(//总学分达标的前提下，平均成绩、受处分次数、重学次数符合学位需求则授予学位证书
                        g.getAccum_credit()>=graduation_requirement.getAccum_credit()&
                        g.getAverage_score()>=graduation_requirement.getAverage_score()&
                        g.getPunishment_time()<=graduation_requirement.getPunishment_time()&
                        g.getRelearn_time()<=graduation_requirement.getRelearn_time()
                ){
                    g.setDegree("1");
                    graduation_auditService.updateCertificate(g.getStudentId(),g.getGraduation(),g.getDegree());
                }
                return new Message(StatusType.SUCCESS_STATUS,"数据更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(StatusType.ERROR_STATUS,"数据更新失败");
    }


}
