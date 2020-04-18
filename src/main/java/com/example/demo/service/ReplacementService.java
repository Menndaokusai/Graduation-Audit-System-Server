package com.example.demo.service;

import com.example.demo.model.Replacement;

import java.util.List;

public interface ReplacementService {

    //查询所有Replacement
    List<Replacement> selectAll(int start,int limit);

    //查询一个学生的Replacement
    List<Replacement> selectBystudentId(String studentId,int start,int limit);

    //增加一个Replacement
    int insert(Replacement replacement);

    //查询一个Replacement
    Replacement selectByreplacementId(int replacementId);

    //修改一个Replacement
    int update(Replacement replacement);

}
