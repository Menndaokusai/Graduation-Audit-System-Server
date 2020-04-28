package com.example.demo.service;

import com.example.demo.model.Score;

import java.util.List;

public interface ScoreService {

    //统计学生信息
    List<Score> getStudentInfo();

    //获得该学生的所有成绩
    List<Score> selectBystudentId(String studentId);

    //获取总学分
    String getAccumCredit(String studentId);

    //获取数据
    List<Score> getData();

    //查询所有Score
    List<Score> selectAll();

    //查询Score
    List<Score> LimitedSelectAll(int start,int limit);

    //查询一个学生的Score
    List<Score> LimitedSelectBystudentId(String studentId,int start,int limit);

    //创建一个Score
    int insert(Score score);

    //删除全部Score
    int deleteAll();

}
