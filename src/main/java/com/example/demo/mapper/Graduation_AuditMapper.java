package com.example.demo.mapper;


import com.example.demo.model.Graduation_Audit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Graduation_AuditMapper {

    //查询所有学生的Audit信息
    @Select("select * from graduation_audit")
    List<Graduation_Audit> selectAll();

    //查询有限的Audit
    @Select("select * from graduation_audit limit #{start},#{limit}")
    List<Graduation_Audit> LimitedSelectAll(int start, int limit);

    //查询该学生的Audit信息
    @Select("select * from graduation_audit where studentId=#{studentId}")
    List<Graduation_Audit> selectBysId(String studentId);

    //添加学生基本信息
    @Insert("insert into graduation_audit(studentId,studentName,studentClass) values(#{studentId},#{studentName},#{studentClass})")
    int insert(String studentId,String studentName,String studentClass);

    //更新学生的总学分、平均成绩、重学次数、处分次数
    @Update("update graduation_audit set accum_credit=#{accum_credit},average_score=#{average_score}" +
                                            ",relearn_time=#{relearn_time},punishment_time=#{punishment_time}" +
                                            "where studentId=#{studentId}")
    int updateAuditData(String studentId,double accum_credit,
                        double average_score,double relearn_time,
                        double punishment_time);

}
