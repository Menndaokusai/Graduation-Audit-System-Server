package com.example.demo.mapper;


import com.example.demo.model.Replacement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReplacementMapper {

    //查询所有Replacement
    @Select("select * from replacement limit #{start},#{limit}")
    List<Replacement> selectAll(int start,int limit);

    //查询一个学生的Replacement
    @Select("select * from replacement where studentId=#{studentId} limit #{start},#{limit}")
    List<Replacement> selectBystudentId(String studentId,int start,int limit);

    //查询一个学生对应课程的Replacement
    @Select("select * from replacement where studentId=#{studentId} and original_course=#{original_course}")
    List<Replacement> find(String studentId,String original_course);

    //增加一个Replacement
    @Insert("insert into replacement values(#{replacementId},#{studentId}" +
                                        ",#{original_course},#{replacement_course_a}" +
                                        ",#{replacement_course_b},#{replacement_course_c}" +
                                        ",#{report_time},#{audit_result})")
    int insert(Replacement replacement);

    //查询一个Replacement
    @Select("select * from replacement where replacementId=#{replacementId}")
    Replacement selectByreplacementId(int replacementId);

    //修改一个Replacement
    @Update("update replacement set studentId=#{studentId}" +
                                ",original_course=#{original_course}" +
                                ",replacement_course_a=#{replacement_course_a}" +
                                ",replacement_course_b=#{replacement_course_b}" +
                                ",replacement_course_c=#{replacement_course_c}" +
                                ",report_time=#{report_time},audit_result=#{audit_result} where replacementId=#{replacementId}")
    int update(Replacement replacement);
}
