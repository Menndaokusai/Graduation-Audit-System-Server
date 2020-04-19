package com.example.demo.service;

import com.example.demo.model.Graduation_Audit;

import java.util.List;

public interface Graduation_AuditService {

    //查询所有学生的Audit信息
    List<Graduation_Audit> selectAll();

    //查询有限的Audit
    List<Graduation_Audit> LimitedSelectAll(int start,int limit);

    //查询该学生的Audit
    List<Graduation_Audit> selectBysId(String studentId);

    //添加学生基本信息
    String insert(String studentId,String studentName,String studentClass);

    //更新审核必要的数据
    int updateAuditData(String studentId,double accum_credit,
                        double average_score,double relarn_time,
                        double punishment_time);
}
