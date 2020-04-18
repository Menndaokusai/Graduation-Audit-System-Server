package com.example.demo.service;

import com.example.demo.model.Graduation_Requirement;

import java.util.List;

public interface Graduation_RequirementService {

    //查询所有Requirement
    List<Graduation_Requirement> selectAll(int start,int limit);

    //查询该入学年份的Requirement
    List<Graduation_Requirement> selectByYear(String enrollment_year,int start,int limit);

    //增加一个Requirement
    int insert(Graduation_Requirement graduation_requirement);

    //删除一个Requirement
    int delete(int requirementId);

    //查询一个Requirement
    Graduation_Requirement select(int requirementId);

    //修改一个Requirement
    int update(Graduation_Requirement graduation_requirement);
}
