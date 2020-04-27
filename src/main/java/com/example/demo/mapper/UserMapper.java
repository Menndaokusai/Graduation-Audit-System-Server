package com.example.demo.mapper;


import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {



    //查询所有User
    @Select("select * from user limit #{start},#{limit}")
    List<User> selectAll(int start,int limit);

    //增加一个User
    @Insert("insert into user values(#{username},#{password},#{roles})")
    int insert(User user);

    //删除一个User
    @Delete("delete from user where username=#{username}")
    int delete(String username);

    //查询一个User
    @Select("select * from user where username=#{username}")
    User select(String username);

    //修改一个User
    @Update("update user set password=#{password},roles=#{roles} where username=#{username}")
    int update(User user);

    //修改一个UserRole
    @Update("update user set roles=#{roles} where username=#{username}")
    int updateRole(User user);

}
