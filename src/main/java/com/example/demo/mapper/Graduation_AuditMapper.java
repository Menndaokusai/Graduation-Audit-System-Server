package com.example.demo.mapper;


import com.example.demo.model.Graduation_Audit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Graduation_AuditMapper {

    //查询所有Audit
    @Select("select * from graduation_audit limit #{start},#{limit}")
    List<Graduation_Audit> selectAll(int start,int limit);

    //查询该学生的Audit
    @Select("select * from graduation_audit where studentId=#{studentId} limit #{start},#{limit}")
    List<Graduation_Audit> selectBysId(String studentId, int start,int limit);

}
