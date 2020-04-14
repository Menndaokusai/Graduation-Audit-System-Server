package com.example.demo.service;

import com.example.demo.mapper.ScoreMapper;
import com.example.demo.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public List<Score> selectAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public List<Score> selectBystudentId(int studentId) {
        return scoreMapper.selectBystudentId(studentId);
    }
}
