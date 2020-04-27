package com.example.demo.service;

import com.example.demo.model.Punishment;
import java.util.List;

public interface PunishmentService {

    //统计一个学生所受的处分次数
    String punishmentTime(String studentId);

    //查询所有Punishment
    List<Punishment> selectAll(int start,int limit);

    //增加一个Punishment
    int insert(Punishment punishment);

    //删除一个Punishment
    int delete(int punishmentId);

    //查询一个学生的Punishment
    Punishment select(int studentId);

    //修改一个Punishment
    int update(Punishment punishment);

}
