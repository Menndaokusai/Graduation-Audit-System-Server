package com.example.demo.service;

import com.example.demo.model.Log;

import java.util.List;

public interface LogService {

    //查询所有Log
    List<Log> selectAll();

    //增加一个Log
    int insert(Log log);

}
