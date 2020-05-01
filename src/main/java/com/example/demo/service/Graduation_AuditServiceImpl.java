package com.example.demo.service;

import com.example.demo.mapper.Graduation_AuditMapper;
import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Score;
import com.example.demo.model.Training_Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Graduation_AuditServiceImpl implements Graduation_AuditService{

    @Autowired
    Graduation_AuditMapper graduation_auditMapper;

    @Override
    public int selectCount() {
        return graduation_auditMapper.selectCount();
    }

    @Override
    public List<Score> selectElectiveCourse(String studentId) {
        return graduation_auditMapper.selectElectiveCourse(studentId);
    }

    @Override
    public List<Score> selectFailedCourse(String studentId) {
        return graduation_auditMapper.selectFailedCourse(studentId);
    }

    @Override
    public List<Training_Program> selectUnChosenCourse(String studentId) {
        return graduation_auditMapper.selectUnChosenCourse(studentId);
    }

    @Override
    public List<Graduation_Audit> selectAll() {
        return graduation_auditMapper.selectAll();
    }

    @Override
    public List<Graduation_Audit> LimitedSelectAll(int start,int limit) {
        return graduation_auditMapper.LimitedSelectAll(start,limit);
    }

    @Override
    public List<Graduation_Audit> selectBysId(String studentId) {
        return graduation_auditMapper.selectBysId(studentId);
    }

    @Override
    public List<Graduation_Audit> selectBycollege(String college) {
        return graduation_auditMapper.selectBycollege(college);
    }

}
