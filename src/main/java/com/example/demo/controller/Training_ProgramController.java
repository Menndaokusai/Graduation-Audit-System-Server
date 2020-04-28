package com.example.demo.controller;

import com.example.demo.model.Training_Program;
import com.example.demo.service.Training_ProgramService;
import com.example.demo.utils.Message;
import com.example.demo.utils.POIUtils;
import com.example.demo.utils.PageList;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/training")
public class Training_ProgramController {


    @Autowired
    Training_ProgramService training_programService;


    //导入Excel数据
    @PostMapping("/import")
    public Object importData(MultipartFile file) throws IOException {
        System.out.println(file);//用来检查前端是否把文件传过来

        int count=0;

        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<Training_Program> training_programs = POIUtils.excel2Training(file.getInputStream());
        // 2.遍历输出你解析的数据格式是否正确
        for (Training_Program t : training_programs) {
            System.out.println(t.toString());
            // 3.进行数据库添加操作
            count+=training_programService.insert(t);
        }

        if(count>0){
            return new Message(StatusType.SUCCESS_STATUS,"上传成功！");
        }

        return new Message(StatusType.ERROR_STATUS,"上传失败！");
    }


    @GetMapping("/list")
    public Object fetchList(String enrollment_year,int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(enrollment_year==null||enrollment_year.equals("")){
            lists = Collections.singletonList(training_programService.selectAll(start,limit));
        }
        else {
            lists = Collections.singletonList(training_programService.selectByYear(enrollment_year,start,limit));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }



}
