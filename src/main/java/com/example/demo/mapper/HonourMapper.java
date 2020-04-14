package com.example.demo.mapper;

import com.example.demo.model.Honour;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface HonourMapper {

    //查询所有Honour
    @Select("select * from honour")
    List<Honour> selectAll();

    //增加一个Honour
    @Insert("insert into honour values(#{honourId},#{studentId},#{honour}" +
                                    ",#{obtain_time},#{record_time})")
    int insert(Honour honour);

    //删除一个Honour
    @Delete("delete from honour where honourId=#{honourId}")
    int delete(int honourId);

    //查询一个Honour
    @Select("select * from honour where honourId=#{honourId}")
    Honour select(int honourId);

    //修改一个Honour
    @Update("update honour set studentId=#{studentId}" +
                            ",honour=#{honour},obtain_time=#{obtain_time}" +
                            ",record_time=#{record_time} where honourId=#{honourId}")
    int update(int honourId);
}
