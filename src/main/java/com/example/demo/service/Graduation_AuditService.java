package com.example.demo.service;

import com.example.demo.model.Graduation_Audit;

import java.util.List;

public interface Graduation_AuditService {

    //查询所有Audit
    List<Graduation_Audit> selectAll(int start,int limit);

    //查询该学生的Audit
    List<Graduation_Audit> selectBysId(String studentId, int start,int limit);
}
