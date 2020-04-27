package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.Message;
import com.example.demo.utils.Messageee;
import com.example.demo.utils.PageList;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public Object selectAll(int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists = Collections.singletonList(studentService.LimitedSelectAll(start, limit));
        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }

    //模拟从教务网获取学生信息
    @GetMapping("/get")
    public Object getData(){
        return new Messageee(StatusType.SUCCESS_STATUS,"获取数据成功", studentService.getData());
    }

    @PostMapping("/create")
    public Object setData(@RequestBody List<Student> list){
        try{
            //检验学生表是否有数据存在
            List<Student> students = studentService.selectAll();
            if(students.size()!=0){
                //存在则删除全部数据
                studentService.deleteAll();
            }
            int count=0;
            //添加数据
            for (Student s: list) {
                int result = studentService.insert(s);
                if(result>0){
                    count++;
                }
            }
            if(count>0){
                return new Message(StatusType.SUCCESS_STATUS,"更新数据成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"更新数据失败");
    }

}
