package com.example.demo.mapper;


import com.example.demo.model.Replacement;
import com.example.demo.model.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ScoreMapper {

    //查询所有Score
    @Select("select * from score")
    List<Score> selectAll();

    //查询一个学生的Score
    @Select("select * from score where studentId=#{studentId}")
    List<Score> selectBystudentId(int studentId);

}
