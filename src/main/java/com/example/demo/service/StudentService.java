package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

        //根据学号查找学生
        Student selectBysId(String studentId);

        //获取Student_Copy中的数据
        List<Student> getData();

        //添加数据
        int insert(Student student);

        //删除学生表的所有数据
        int deleteAll();

        //获取Student中的数据
        List<Student> selectAll();

        //有限的获取Student中的数据
        List<Student> LimitedSelectAll(int start,int limit);
}
