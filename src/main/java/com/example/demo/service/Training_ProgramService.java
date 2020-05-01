package com.example.demo.service;

import com.example.demo.model.Training_Program;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Training_ProgramService {

    //查询培养方案的数量
    int selectCount();

    //清空培养方案表
    int Truncate();

    //查询所有培养方案
    List<Training_Program> findAll();

    //分页查询培养方案
    List<Training_Program> selectAll(int start, int limit);

    //查询该入学年份的培养方案
    List<Training_Program> selectByYear(String enrollment_year, int start, int limit);

    //增加一个培养方案
    int insert(Training_Program training_program);
}
