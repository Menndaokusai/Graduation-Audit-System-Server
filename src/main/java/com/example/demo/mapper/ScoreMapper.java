package com.example.demo.mapper;


import com.example.demo.model.Replacement;
import com.example.demo.model.Score;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ScoreMapper {

    //获取Score_Copy的数据
    @Select("select * from score_copy")
    List<Score> getData();

    //查询所有Score
    @Select("select * from score limit #{start},#{limit}")
    List<Score> selectAll(int start,int limit);

    //查询一个学生的Score
    @Select("select * from score where studentId=#{studentId} limit #{start},#{limit}")
    List<Score> selectBystudentId(String studentId,int start,int limit);

    //创建Score
    @Insert("insert into score values(#{scoreId},#{studentId},#{studentName}" +
                                    ",#{studentClass},#{college},#{academic_year}" +
                                    ",#{term},#{course_name},#{credit}" +
                                    ",#{score},#{retry_score},#{relearn_score})")
    int insert(Score score);

    //删除全部Score
    @Delete("delete * from score")
    int deleteAll();

}
