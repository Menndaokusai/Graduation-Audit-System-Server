package com.example.demo.service;

import com.example.demo.model.Score;

import java.util.List;

public interface ScoreService {

    //查询所有Score
    List<Score> selectAll();

    //查询一个学生的Score
    List<Score> selectBystudentId(int studentId);

}
