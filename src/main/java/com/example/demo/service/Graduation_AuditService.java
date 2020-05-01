package com.example.demo.service;

import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Score;
import com.example.demo.model.Training_Program;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface Graduation_AuditService {

    //查询学生人数
    int selectCount();

    //查询学生的所有选修课程
    List<Score> selectElectiveCourse(String studentId);

    //查询该学生的不及格课程
    List<Score> selectFailedCourse(String studentId);

    //查询学生未修的必修课
    List<Training_Program> selectUnChosenCourse(String studentId);

    //查询所有学生的Audit信息
    List<Graduation_Audit> selectAll();

    //查询有限的Audit
    List<Graduation_Audit> LimitedSelectAll(int start,int limit);

    //查询该学生的Audit
    List<Graduation_Audit> selectBysId(String studentId);

    //查询分院的所有学生的Audit信息
    List<Graduation_Audit> selectBycollege(String college);
}
