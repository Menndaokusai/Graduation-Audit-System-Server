package com.example.demo.mapper;


import com.example.demo.model.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ScoreMapper {

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

    //获取Score_Copy的数据
    @Select("select * from score_copy")
    List<Score> getData();

    //查询所有学生的Score
    @Select("select * from score")
    List<Score> selectAll();

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
    @Insert("insert into score values(#{scoreId},#{studentId},#{studentName}" +
                                    ",#{studentClass},#{college},#{academic_year}" +
                                    ",#{term},#{course_name},#{credit}" +
                                    ",#{score},#{retry_score},#{relearn_score})")
    int insert(Score score);

    //删除全部Score
    @Delete("truncate table score")
    int deleteAll();

}
