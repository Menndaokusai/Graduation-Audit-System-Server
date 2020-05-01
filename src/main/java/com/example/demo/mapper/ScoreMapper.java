package com.example.demo.mapper;


import com.example.demo.model.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ScoreMapper {

    //获取学生某课程的修读情况
    @Select("select \n" +
            "*\n" +
            "FROM score\n" +
            "where course_name LIKE #{course_name}\n" +
            "and studentId=#{studentId}")
    List<Score> getCourse(String course_name,String studentId);

    //统计学生信息
    @Select("select DISTINCT studentId,studentName,college,major,studentClass from score ORDER BY studentId")
    List<Score> getStudentInfo();

    //统计学生的总学分
    @Select("SELECT\n" +
            "\tSUM(credit)\n" +
            "FROM\n" +
            "\tscore\n" +
            "WHERE\n" +
            "\tstudentId = #{studentId}\n" +
            "AND score >= 60\n" +
            "OR retry_score >= 60\n" +
            "OR relearn_score >= 60")
    String getAccumCredit(String studentId);

    //查询所有学生的Score
    @Select("select * from score")
    List<Score> selectAll();

    //查询Score的总数
    @Select("select COUNT(*) from score")
    int selectCount();

    //查询有限的Score
    @Select("select * from score limit #{start},#{limit}")
    List<Score> LimitedSelectAll(int start,int limit);

    //查询一个学生的所有Score
    @Select("select * from score where studentId=#{studentId}")
    List<Score> selectBystudentId(String studentId);

    //查询一个学生有限的Score
    @Select("select * from score where studentId=#{studentId} limit #{start},#{limit}")
    List<Score> LimitedSelectBystudentId(String studentId,int start,int limit);

    //创建Score
    @Insert("insert into score values(#{scoreId},#{studentId},#{studentName},#{enrollment_year}" +
                                    ",#{college},#{major},#{studentClass},#{academic_year}" +
                                    ",#{term},#{courseId},#{course_name},#{course_nature},#{credit}" +
                                    ",#{score},#{retry_score},#{relearn_score},#{relearn_mark})")
    int insert(Score score);

    //删除全部Score
    @Delete("truncate table score")
    int deleteAll();

}
