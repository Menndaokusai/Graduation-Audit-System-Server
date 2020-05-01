package com.example.demo.mapper;


import com.example.demo.model.Graduation_Requirement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Graduation_RequirementMapper {

    //查询毕业需求的数量
    @Select("select COUNT(*) from graduation_requirement")
    int selectCount();

    //查询全部
    @Select("select * from graduation_requirement")
    List<Graduation_Requirement> findAll();

    //清空毕业需求表
    @Delete("truncate table graduation_requirement")
    int Truncate();

    //查询所有Requirement
    @Select("select * from graduation_requirement limit #{start},#{limit}")
    List<Graduation_Requirement> selectAll(int start, int limit);

    //查询该入学年份的Requirement
    @Select("select * from graduation_requirement where enrollment_year=#{enrollment_year} limit #{start},#{limit}")
    List<Graduation_Requirement> selectByYear(String enrollment_year, int start, int limit);

    //查询该年级的该专业的毕业需求
    @Select("select * from graduation_requirement where enrollment_year=#{enrollment_year} and major=#{major}")
    List<Graduation_Requirement> selectByCollegeAndYearAndMajor(String enrollment_year ,String major);

    //增加一个Requirement
    @Insert("insert into graduation_requirement values(#{requirementId},#{enrollment_year},#{major}" +
                                                    ",#{required_course_credit},#{elective_course_credit})")
    int insert(Graduation_Requirement graduation_requirement);

    //删除一个Requirement
    @Delete("delete from graduation_requirement where requirementId=#{requirementId}")
    int delete(int requirementId);

    //查询一个Requirement
    @Select("select * from graduation_requirement where requirementId=#{requirementId}")
    Graduation_Requirement select(int requirementId);

    //修改一个Requirement
    @Update("update graduation_requirement set enrollment_year=#{enrollment_year}" +
                                            ",major=#{major},required_course_credit=#{required_course_credit}" +
                                            ",elective_course_credit=#{elective_course_credit} where requirementId=#{requirementId}")
    int update(Graduation_Requirement graduation_requirement);
}
