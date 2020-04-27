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
    public List<Score> selectBystudentId(String studentId) {
        return scoreMapper.selectBystudentId(studentId);
    }

    @Override
    public String getAccumCredit(String studentId) {
        return scoreMapper.getAccumCredit(studentId);
    }

    @Override
    public List<Score> getData() {
        return scoreMapper.getData();
    }

    @Override
    public List<Score> selectAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public List<Score> LimitedSelectAll(int start,int limit) {
        return scoreMapper.LimitedSelectAll(start, limit);
    }

    @Override
    public List<Score> LimitedSelectBystudentId(String studentId,int start,int limit) {
        return scoreMapper.LimitedSelectBystudentId(studentId,start,limit);
    }

    @Override
    public int insert(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public int deleteAll() {
        return scoreMapper.deleteAll();
    }


}
