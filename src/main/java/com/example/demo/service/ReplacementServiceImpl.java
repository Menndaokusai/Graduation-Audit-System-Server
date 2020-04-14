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
    public List<Replacement> selectAll() {
        return replacementMapper.selectAll();
    }

    @Override
    public List<Replacement> selectBystudentId(int studentId) {
        return replacementMapper.selectBystudentId(studentId);
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
