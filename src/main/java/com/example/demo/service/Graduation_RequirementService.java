package com.example.demo.service;

import com.example.demo.model.Graduation_Requirement;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Graduation_RequirementService {

    //查询毕业需求的数量
    int selectCount();

    //查询全部
    List<Graduation_Requirement> findAll();

    //清空毕业需求表
    int Truncate();

    //查询该学院的该年级的该专业的毕业需求
    List<Graduation_Requirement> selectByYearAndMajor(String enrollment_year ,String major);

    //查询所有Requirement
    List<Graduation_Requirement> selectAll(int start, int limit);

    //查询该入学年份的Requirement
    List<Graduation_Requirement> selectByYear(String enrollment_year, int start, int limit);

    //增加一个Requirement
    int insert(Graduation_Requirement graduation_requirement);

    //删除一个Requirement
    int delete(int requirementId);

    //查询一个Requirement
    Graduation_Requirement select(int requirementId);

    //修改一个Requirement
    int update(Graduation_Requirement graduation_requirement);
}
