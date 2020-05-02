package com.example.demo.controller;

import com.example.demo.model.Replacement;
import com.example.demo.model.Training_Program;
import com.example.demo.model.Score;
import com.example.demo.service.ReplacementService;
import com.example.demo.utils.Message;
import com.example.demo.utils.PageList;
import com.example.demo.service.Graduation_AuditService;
import com.example.demo.service.ScoreService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class Graduation_AuditController {

    @Autowired
    Graduation_AuditService graduation_auditService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    ReplacementService replacementService;

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

        int total = graduation_auditService.selectCount();

        return new PageList(StatusType.SUCCESS_STATUS,lists,total);
    }

    @GetMapping("/detail")
    public Object getDetail(String studentId){

        //获得学生不及格的课程信息
        List<Score> scores = graduation_auditService.selectFailedCourse(studentId);
        //获得学生未修的必修课信息
        List<Training_Program> training_programs = graduation_auditService.selectUnChosenCourse(studentId);
        //获得学生选修的选修课信息
        List<Score> escore = graduation_auditService.selectElectiveCourse(studentId);

        for (int i = 0 ;i<training_programs.size();i++) {
            Training_Program t = training_programs.get(i);
            if(t.getCourse_name().contains("体育(一)")
                    ||t.getCourse_name().contains("体育(二)")
                    ||t.getCourse_name().contains("体育(三)")
                    ||t.getCourse_name().contains("体育(四)")){
                String course_name = t.getCourse_name();
                System.out.println(course_name);
                List<Score> slist = scoreService.getCourse("%"+course_name+"%",studentId);
                System.out.println(slist);
                if(slist.size()!=0){
                    training_programs.remove(i);
                    i--;
                }
            }
        }

        for (int i = 0 ; i<scores.size();i++){
            Score s =scores.get(i);
            List<Replacement> replacements = replacementService.selectBysIdAndCourseId(studentId,s.getCourseId());
            if(replacements.size()!=0){
                scores.remove(i);
                i--;
            }
        }


        //添加进List
        List<Object> list = new ArrayList<>();
        list.add(scores);
        list.add(training_programs);
        list.add(escore);

        return new PageList(StatusType.SUCCESS_STATUS,list);
    }

    @GetMapping("/replace")
    public Object replace(String studentId,String original_courseId,String replace_courseId){

        System.out.println(studentId+" "+original_courseId+" "+replace_courseId);

        Replacement replacement = new Replacement(0,studentId,original_courseId,replace_courseId);

        int result = replacementService.insert(replacement);

        if(result==1){
            return new Message(StatusType.SUCCESS_STATUS,"操作成功");
        }

        return new Message(StatusType.ERROR_STATUS,"操作失败");
    }

}
