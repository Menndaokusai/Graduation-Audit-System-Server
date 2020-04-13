package com.example.demo.mapper;

import com.example.demo.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleMapper {

    //查询所有Role
    @Select("select * from role")
    List<Role> selectAllRole();

}
