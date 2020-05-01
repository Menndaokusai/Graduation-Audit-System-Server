package com.example.demo.controller;


import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Punishment;
import com.example.demo.service.Graduation_AuditService;
import com.example.demo.service.PunishmentService;
import com.example.demo.utils.*;
import com.example.demo.model.Score;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    //导入Excel数据
    @PostMapping("/import")
    public Object importData(MultipartFile file) throws IOException {
        System.out.println(file);//用来检查前端是否把文件传过来

        //清空课程成绩表中的数据
        if(scoreService.selectAll().size()!=0){
            scoreService.deleteAll();
        }

        int count=0;

        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<Score> scores = POIUtils.excel2Score(file.getInputStream());
        // 2.遍历输出你解析的数据格式是否正确
        for (Score score : scores) {
            System.out.println(score.toString());
            // 3.进行数据库添加操作
            if (score.getRetry_score()==null||score.getRetry_score().equals("")){
                score.setRetry_score("0");
            }
            if (score.getRelearn_score()==null){
                score.setRelearn_score("0");
            }
                count+=scoreService.insert(score);
        }

        if(count>0){
            return new Message(StatusType.SUCCESS_STATUS,"上传成功！");
        }

        return new Message(StatusType.ERROR_STATUS,"上传失败！");
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

        int total = scoreService.selectCount();

        return new PageList(StatusType.SUCCESS_STATUS,lists,total);
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