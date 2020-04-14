package com.example.demo.mapper;


import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    //查询所有User
    @Select("select * from user")
    List<User> selectAll();

    //增加一个User
    @Insert("insert into user values(#{account},#{password},#{roleId})")
    int insert(User user);

    //删除一个User
    @Delete("delete from user where account=#{account}")
    int delete(String account);

    //查询一个User
    @Select("select * from user where account=#{account}")
    User select(String account);

    //修改一个User
    @Update("update user set password=#{password},roleId=#{roleId} where account=#{account}")
    int update(User user);

}
