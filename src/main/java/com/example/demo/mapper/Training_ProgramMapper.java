package com.example.demo.mapper;

import com.example.demo.model.Graduation_Requirement;
import com.example.demo.model.Training_Program;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Training_ProgramMapper {

    //清空培养方案表
    @Delete("truncate table training_program")
    int Truncate();

    //查询所有培养方案
    @Select("select * from training_program")
    List<Training_Program> findAll();

    //分页查询培养方案
    @Select("select * from training_program limit #{start},#{limit}")
    List<Training_Program> selectAll(int start, int limit);

    //查询该入学年份的培养方案
    @Select("select * from training_program where enrollment_year=#{enrollment_year} limit #{start},#{limit}")
    List<Training_Program> selectByYear(String enrollment_year, int start, int limit);

    //增加一个培养方案
    @Insert("insert into training_program values(#{trainingId},#{enrollment_year},#{college},#{major}" +
            ",#{courseId},#{course_name},#{credit}" +
            ",#{course_nature},#{recommend_term})")
    int insert(Training_Program training_program);

}
