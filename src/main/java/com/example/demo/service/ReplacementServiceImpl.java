package com.example.demo.service;

import com.example.demo.mapper.ReplacementMapper;
import com.example.demo.model.Replacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplacementServiceImpl implements ReplacementService{

    @Autowired
    ReplacementMapper replacementMapper;

    @Override
    public List<Replacement> find(String studentId, String original_course) {
        return replacementMapper.find(studentId, original_course);
    }

    @Override
    public List<Replacement> selectAll(int start,int limit) {
        return replacementMapper.selectAll(start, limit);
    }

    @Override
    public List<Replacement> selectBystudentId(String studentId,int start,int limit) {
        return replacementMapper.selectBystudentId(studentId,start,limit);
    }

    @Override
    public int insert(Replacement replacement) {
        return replacementMapper.insert(replacement);
    }

    @Override
    public Replacement selectByreplacementId(int replacementId) {
        return replacementMapper.selectByreplacementId(replacementId);
    }

    @Override
    public int update(Replacement replacement) {
        return replacementMapper.update(replacement);
    }
}
