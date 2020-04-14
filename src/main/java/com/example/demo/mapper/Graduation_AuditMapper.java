package com.example.demo.mapper;


import com.example.demo.model.Graduation_Audit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Graduation_AuditMapper {

    //查询所有Audit
    @Select("select * from graduation_audit")
    List<Graduation_Audit> selectAll();

}
