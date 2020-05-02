package com.example.demo.mapper;

import com.example.demo.model.Replacement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReplacementMapper {

    //按照学号和原课程代码查询
    @Select("select * from replacement where studentId=#{studentId} and original_courseId=#{original_courseId}")
    List<Replacement> selectBysIdAndCourseId(String studentId,String original_courseId);

    //添加
    @Insert("insert into replacement values(#{id},#{studentId},#{original_courseId},#{replace_courseId})")
    int insert(Replacement replacement);

}
