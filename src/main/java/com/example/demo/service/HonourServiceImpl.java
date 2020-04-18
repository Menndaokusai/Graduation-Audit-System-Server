package com.example.demo.service;


import com.example.demo.mapper.HonourMapper;
import com.example.demo.model.Honour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HonourServiceImpl implements HonourService{

    @Autowired
    HonourMapper honourMapper;

    @Override
    public List<Honour> selectAll(int start,int limit) {
        return honourMapper.selectAll(start, limit);
    }

    @Override
    public int insert(Honour honour) {
        return honourMapper.insert(honour);
    }

    @Override
    public int delete(int honourId) {
        return honourMapper.delete(honourId);
    }

    @Override
    public Honour select(int honourId) {
        return honourMapper.select(honourId);
    }

    @Override
    public List<Honour> selectBysId(String studentId, int start, int limit) {
        return honourMapper.selectBysId(studentId,start,limit);
    }

    @Override
    public int update(Honour honour) {
        return honourMapper.update(honour);
    }

}
