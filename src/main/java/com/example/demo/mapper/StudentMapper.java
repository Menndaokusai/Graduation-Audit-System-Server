package com.example.demo.mapper;


import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    //获取Student_Copy中的数据
    @Select("select * from student_copy")
    List<Student> getData();

    //获取Student中的数据
    @Select("select * from student")
    List<Student> selectAll();

    //获取Student中的数据
    @Select("select * from student limit #{start},#{limit}")
    List<Student> LimitedSelectAll(int start,int limit);

    //添加数据
    @Insert("insert into student values(#{studentId},#{major},#{enrollment_year},#{system})")
    int insert(Student student);

    //删除学生表的所有数据
    @Delete("truncate table student")
    int deleteAll();

}
