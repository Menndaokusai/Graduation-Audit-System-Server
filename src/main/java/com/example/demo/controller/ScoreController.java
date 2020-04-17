package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.model.Score;
import com.example.demo.service.ScoreService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @GetMapping("/list")
    public Object fetchList(){
        List<Object> lists = Collections.singletonList(scoreService.selectAll());

        return new Message(StatusType.SUCCESS_STATUS,"获取列表成功",lists);
    }

    @PostMapping("/create")
    public Object createScore(int studentId,
                              String studentName, String studentClass,
                              String college, String academic_year,
                              String term, String course_name,
                              Double credit, Double score,
                              Double retry_score, Double relearn_score){

        Score sscore = new Score(0,studentId, studentName,studentClass,
                                college,academic_year,term,course_name,
                                credit,score,retry_score,relearn_score);
        try {
            int result = scoreService.insert(sscore);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");

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