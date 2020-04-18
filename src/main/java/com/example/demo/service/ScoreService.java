package com.example.demo.service;

import com.example.demo.model.Score;

import java.util.List;

public interface ScoreService {

    //获取数据
    List<Score> getData();

    //查询所有Score
    List<Score> selectAll(int start,int limit);

    //查询一个学生的Score
    List<Score> selectBystudentId(String studentId,int start,int limit);

    //创建一个Score
    int insert(Score score);

    //删除全部Score
    int deleteAll();

}
