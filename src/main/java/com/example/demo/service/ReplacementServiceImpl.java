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
    public List<Replacement> selectBysIdAndCourseId(String studentId, String original_courseId) {
        return replacementMapper.selectBysIdAndCourseId(studentId, original_courseId);
    }

    @Override
    public int insert(Replacement replacement) {
        return replacementMapper.insert(replacement);
    }
}
