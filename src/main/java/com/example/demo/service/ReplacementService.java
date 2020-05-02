package com.example.demo.service;

import com.example.demo.model.Replacement;

import java.util.List;

public interface ReplacementService {

    //按照学号和原课程代码查询
    List<Replacement> selectBysIdAndCourseId(String studentId, String original_courseId);

    //添加
    int insert(Replacement replacement);

}
