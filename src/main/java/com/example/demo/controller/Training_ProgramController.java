package com.example.demo.controller;

import com.example.demo.model.Graduation_Requirement;
import com.example.demo.model.Training_Program;
import com.example.demo.service.Graduation_RequirementService;
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
    @Autowired
    Graduation_RequirementService graduation_requirementService;


    //导入Excel数据
    @PostMapping("/import")
    public Object importData(MultipartFile file) throws IOException {
        System.out.println(file);//用来检查前端是否把文件传过来

        //清空毕业需求表与培养方案表
        if (graduation_requirementService.findAll().size()!=0){
            graduation_requirementService.Truncate();
        }
        if (training_programService.findAll().size()!=0){
            training_programService.Truncate();
        }

        int count=0;

        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<Training_Program> training_programs = POIUtils.excel2Training(file.getInputStream());
        // 2.遍历输出你解析的数据格式是否正确
        for (Training_Program t : training_programs) {
            System.out.println(t.toString());
            // 3.进行数据库添加操作
            count+=training_programService.insert(t);
            //获得这门课程的性质
            String course_nature = t.getCourse_nature();
            String required_course_credit = "0";//必修课学分
            if (course_nature.equals("必修课")){
                //获得这门课程的学分
                required_course_credit = t.getCredit();
            }
            //获得开课学院
            String college = t.getCollege();
            //获得开课年级
            String enrollment_year = t.getEnrollment_year();
            //获得开课专业
            String major = t.getMajor();
            //查询是否已存在该学院、该年级、该专业的毕业需求
            List<Graduation_Requirement> graduation_requirements = graduation_requirementService.selectByCollegeAndYearAndMajor(college,enrollment_year,major);
            if (graduation_requirements.size()==0){
                //如果不存在的话就添加
                Graduation_Requirement gr = new Graduation_Requirement(0,enrollment_year,college,major,required_course_credit,"待添加");
                graduation_requirementService.insert(gr);
            }
            else {
                //如果存在的话就更新毕业需求中的必修课学分
                Graduation_Requirement gr = graduation_requirements.get(0);
                //获得目前的必修课学分
                double credit = Double.parseDouble(gr.getRequired_course_credit());
                credit+=Double.parseDouble(required_course_credit);
                gr.setRequired_course_credit(String.valueOf(credit));
                //更新毕业需求
                graduation_requirementService.update(gr);
            }

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
