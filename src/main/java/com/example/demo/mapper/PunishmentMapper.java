package com.example.demo.mapper;

import com.example.demo.model.Punishment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PunishmentMapper {

    //查询所有Punishment
    @Select("select * from punishment limit #{start},#{limit}")
    List<Punishment> selectAll(int start,int limit);

    //增加一个Punishment
    @Insert("insert into punishment values(#{punishmentId},#{studentId},#{punishment}" +
                                        ",#{reason},#{record_time})")
    int insert(Punishment punishment);

    //删除一个Punishment
    @Delete("delete from punishment where punishmentId=#{punishmentId}")
    int delete(int punishmentId);

    //查询一个学生的Punishment
    @Select("select * from punishment where studentId=#{studentId}")
    Punishment select(int studentId);

    //修改一个Punishment
    @Update("update punishment set studentId=#{studentId}" +
                                ",punishment=#{punishment},reason=#{reason}" +
                                ",record_time=#{record_time} where punishmentId=#{punishmentId}")
    int update(Punishment punishment);

}
