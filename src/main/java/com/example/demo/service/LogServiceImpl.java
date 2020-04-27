package com.example.demo.service;

import com.example.demo.mapper.LogMapper;
import com.example.demo.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    LogMapper logMapper;


    @Override
    public List<Log> selectAll() {
        return logMapper.selectAll();
    }

    @Override
    public int insert(Log log) {
        return logMapper.insert(log);
    }
}
