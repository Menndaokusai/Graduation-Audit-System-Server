package com.example.demo.controller;


import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Punishment;
import com.example.demo.service.Graduation_AuditService;
import com.example.demo.service.PunishmentService;
import com.example.demo.utils.Message;
import com.example.demo.utils.Messagee;
import com.example.demo.utils.PageList;
import com.example.demo.model.Score;
import com.example.demo.service.ScoreService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @Autowired
    Graduation_AuditService graduation_auditService;

    @Autowired
    PunishmentService punishmentService;

    //模拟从教务网获取数据
    @GetMapping("/get")
    public Object getData(){
        return new Messagee(StatusType.SUCCESS_STATUS,"获取数据成功", scoreService.getData());
    }

    @PostMapping("/create")
    public Object setData(@RequestBody List<Score> list){
        //如果成绩表中有旧的数据存在的话
        List<Score> scoreList = scoreService.selectAll();
        if(scoreList.size()!=0){
            //删除成绩表中的所有数据
            scoreService.deleteAll();
        }

        List<Graduation_Audit> graduation_auditList;
        int count=0;//统计获取的数据量
        int result=0;//数据插入结果
        try {
            for (Score s: list) {
                s.setScoreId(0);
                //为成绩表添加最新的成绩数据
                result = scoreService.insert(s);

                //检验审核表中是否存在该学生的记录
                graduation_auditList = graduation_auditService.selectBysId(s.getStudentId());
                if(graduation_auditList.size()==0){
                    //不存在则添加进审核表
                    graduation_auditService.insert(s.getStudentId(),s.getStudentName(),s.getStudentClass());
                }

                if(result>0){
                    count++;
                }
            }
            //统计学分，平均成绩，处分，重学次数
            if(count>0){
                //获得审核表中所有学生的信息
                List<Graduation_Audit> graduation_audits = graduation_auditService.selectAll();
                for (Graduation_Audit g: graduation_audits) {
                    //获得该学生的总学分
                    String accum_credit =  scoreService.getAccumCredit(g.getStudentId());
                    if (accum_credit==null){
                        accum_credit="0";
                    }
                    //获得该学生的总处分次数
                    String punishment_time = punishmentService.punishmentTime(g.getStudentId());
                    if (punishment_time==null){
                        punishment_time="0";
                    }
                    //获得该学生的所有成绩
                    List<Score> scores = scoreService.selectBystudentId(g.getStudentId());
                    double totalScore=0;//总成绩
                    double totalCourse=0;//总课程数
                    double relearn_time=0;//重学次数
                    for (Score s: scores) {
                        totalCourse++;
                        if(s.getRelearn_score()>0){
                            totalScore+=s.getRelearn_score();
                            relearn_time++;
                        }
                        else if (s.getRetry_score()>0){
                            totalScore+=s.getRetry_score();
                        }
                        else {
                            totalScore+=s.getScore();
                        }
                    }
                    double average_score=totalScore/totalCourse;//平均成绩
                    //更新该学生的学分，平均成绩，处分，重学次数
                    graduation_auditService.updateAuditData(g.getStudentId(),Double.parseDouble(accum_credit),
                                                            average_score,relearn_time,Double.parseDouble(punishment_time));
                }
                return new Message(StatusType.SUCCESS_STATUS,"数据更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(StatusType.ERROR_STATUS,"数据更新失败");
    }

    @GetMapping("/list")
    public Object fetchList(String studentId,int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(scoreService.LimitedSelectAll(start,limit));
        }
        else{
            lists = Collections.singletonList(scoreService.LimitedSelectBystudentId(studentId,start,limit));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }

    @GetMapping("/delete")
    public Object deleteAll(){
        try {
            int result = scoreService.deleteAll();
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(StatusType.ERROR_STATUS,"删除失败");
    }

}