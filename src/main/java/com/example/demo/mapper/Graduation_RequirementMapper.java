package com.example.demo.mapper;


import com.example.demo.model.Graduation_Requirement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Graduation_RequirementMapper {

    //查询所有Requirement
    @Select("select * from graduation_requirement")
    List<Graduation_Requirement> selectAll();

    //增加一个Requirement
    @Insert("insert into graduation_requirement values(#{requirementId},#{enrollment_year},#{major}" +
                                                    ",#{system},#{accum_credit},#{average_score}" +
                                                    ",#{relearn_time},#{punishment_time},#{update_time})")
    int insert(Graduation_Requirement graduation_requirement);

    //删除一个Requirement
    @Delete("delete from graduation_requirement where requirementId=#{requirementId}")
    int delete(int requirementId);

    //查询一个Requirement
    @Select("select * from graduation_requirement where requirementId=#{requirementId}")
    Graduation_Requirement select(int requirementId);

    //修改一个Requirement
    @Update("update graduation_requirement set enrollment_year=#{enrollment_year}" +
                                            ",major=#{major},system=#{system}" +
                                            ",accum_credit=#{accum_credit},average_score=#{average_score}" +
                                            ",relearn_time=#{relearn_time},punishment_time=#{punishment_time}" +
                                            ",update_time=#{update_time} where requirementId=#{requirementId}")
    int update(int requirementId);
}
