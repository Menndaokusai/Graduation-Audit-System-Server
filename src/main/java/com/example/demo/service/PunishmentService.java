package com.example.demo.service;

import com.example.demo.model.Punishment;
import java.util.List;

public interface PunishmentService {

    //查询所有Punishment
    List<Punishment> selectAll();

    //增加一个Punishment
    int insert(Punishment punishment);

    //删除一个Punishment
    int delete(int punishmentId);

    //查询一个Punishment
    Punishment select(int punishmentId);

    //修改一个Punishment
    int update(int punishmentId);

}
