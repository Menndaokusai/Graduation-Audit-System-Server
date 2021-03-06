package com.example.demo.mapper;


import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Score;
import com.example.demo.model.Training_Program;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Graduation_AuditMapper {

    //查询学生的所有选修课程
    @Select("select \n" +
            "*\n" +
            "from score\n" +
            "WHERE course_nature!='必修课'\n" +
            "and studentId=#{studentId}")
    List<Score> selectElectiveCourse(String studentId);

    //查询该学生的不及格课程
    @Select("select \n" +
            "*\n" +
            "from score \n" +
            "where\n" +
            "(score<60 and (score NOT IN ('及格','合格','中等','良好','优秀')))\n" +
            "and studentId=#{studentId}")
    List<Score> selectFailedCourse(String studentId);

    //查询学生未修的必修课
    @Select("select\n" +
            "*\n" +
            "from training_program\n" +
            "where course_nature='必修课' \n" +
            "and enrollment_year=(SELECT DISTINCT enrollment_year from score where studentId=#{studentId})\n" +
            "and major=(SELECT DISTINCT major from score where studentId=#{studentId})\n" +
            "and courseId \n" +
            "not IN \n" +
            "(\n" +
            "SELECT\n" +
            "courseId\n" +
            "from score\n" +
            "where course_nature='必修课'\n" +
            "and studentId=#{studentId}\n" +
            ")")
    List<Training_Program> selectUnChosenCourse(String studentId);

    //查询学生人数
    @Select("select COUNT(*) from graduation_audit")
    int selectCount();

    //查询所有学生的Audit信息
    @Select("select * from graduation_audit")
    List<Graduation_Audit> selectAll();

    //查询有限的Audit
    @Select("select * from graduation_audit limit #{start},#{limit}")
    List<Graduation_Audit> LimitedSelectAll(int start, int limit);

    //查询该学生的Audit信息
    @Select("select * from graduation_audit where studentId=#{studentId}")
    List<Graduation_Audit> selectBysId(String studentId);

    //查询分院的所有学生的Audit信息
    @Select("select * from graduation_audit where college=#{college}")
    List<Graduation_Audit> selectBycollege(String college);


}
