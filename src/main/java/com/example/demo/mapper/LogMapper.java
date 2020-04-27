package com.example.demo.mapper;

import com.example.demo.model.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LogMapper {

    //查询所有Log
    @Select("select * from log")
    List<Log> selectAll();

    //增加一个Log
    @Insert("insert into log values(#{logId},#{who},#{what},#{when})")
    int insert(Log log);

}
