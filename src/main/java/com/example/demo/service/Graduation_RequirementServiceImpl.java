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
    public List<Graduation_Requirement> selectAll() {
        return graduation_requirementMapper.selectAll();
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
