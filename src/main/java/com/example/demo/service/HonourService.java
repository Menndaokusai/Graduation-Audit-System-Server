package com.example.demo.service;

import com.example.demo.model.Honour;

import java.util.List;

public interface HonourService {

    //查询所有Honour
    List<Honour> selectAll();

    //增加一个Honour
    int insert(Honour honour);

    //删除一个Honour
    int delete(int honourId);

    //查询一个Honour
    Honour select(int honourId);

    //修改一个Honour
    int update(int honourId);

}
