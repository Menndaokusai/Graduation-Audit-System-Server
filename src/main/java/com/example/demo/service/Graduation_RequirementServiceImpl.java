package com.example.demo.service;

import com.example.demo.mapper.Graduation_RequirementMapper;
import com.example.demo.model.Graduation_Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Graduation_RequirementServiceImpl implements Graduation_RequirementService{


    @Autowired
    Graduation_RequirementMapper graduation_requirementMapper;


    @Override
    public List<Graduation_Requirement> findAll() {
        return graduation_requirementMapper.findAll();
    }

    @Override
    public int Truncate() {
        return graduation_requirementMapper.Truncate();
    }

    @Override
    public List<Graduation_Requirement> selectByCollegeAndYearAndMajor(String college, String enrollment_year, String major) {
        return graduation_requirementMapper.selectByCollegeAndYearAndMajor(college, enrollment_year, major);
    }

    @Override
    public List<Graduation_Requirement> selectByCollege(String college, int start, int limit) {
        return graduation_requirementMapper.selectByCollege(college, start, limit);
    }

    @Override
    public List<Graduation_Requirement> selectByCollegeAndYear(String college, String enrollment_year, int start, int limit) {
        return graduation_requirementMapper.selectByCollegeAndYear(college, enrollment_year, start, limit);
    }

    @Override
    public Graduation_Requirement find(String major, String enrollment_year, String system) {
        return graduation_requirementMapper.find(major, enrollment_year, system);
    }

    @Override
    public List<Graduation_Requirement> selectAll(int start, int limit) {
        return graduation_requirementMapper.selectAll(start,limit);
    }

    @Override
    public List<Graduation_Requirement> selectByYear(String enrollment_year, int start, int limit) {
        return graduation_requirementMapper.selectByYear(enrollment_year, start, limit);
    }

    @Override
    public int insert(Graduation_Requirement graduation_requirement) {
        return graduation_requirementMapper.insert(graduation_requirement);
    }

    @Override
    public int delete(int requirementId) {
        return graduation_requirementMapper.delete(requirementId);
    }

    @Override
    public Graduation_Requirement select(int requirementId) {
        return graduation_requirementMapper.select(requirementId);
    }

    @Override
    public int update(Graduation_Requirement graduation_requirement) {
        return graduation_requirementMapper.update(graduation_requirement);
    }


}
