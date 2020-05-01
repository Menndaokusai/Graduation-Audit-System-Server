package com.example.demo.service;

import com.example.demo.mapper.Training_ProgramMapper;
import com.example.demo.model.Training_Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Training_ProgramServiceImpl implements Training_ProgramService{

    @Autowired
    Training_ProgramMapper training_programMapper;

    @Override
    public int selectCount() {
        return training_programMapper.selectCount();
    }

    @Override
    public int Truncate() {
        return training_programMapper.Truncate();
    }

    @Override
    public List<Training_Program> findAll() {
        return training_programMapper.findAll();
    }

    @Override
    public List<Training_Program> selectAll(int start, int limit) {
        return training_programMapper.selectAll(start, limit);
    }

    @Override
    public List<Training_Program> selectByYear(String enrollment_year, int start, int limit) {
        return training_programMapper.selectByYear(enrollment_year, start, limit);
    }

    @Override
    public int insert(Training_Program training_program) {
        return training_programMapper.insert(training_program);
    }
}
