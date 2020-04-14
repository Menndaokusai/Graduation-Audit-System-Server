package com.example.demo.service;

import com.example.demo.mapper.Graduation_AuditMapper;
import com.example.demo.model.Graduation_Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Graduation_AuditServiceImpl implements Graduation_AuditService{

    @Autowired
    Graduation_AuditMapper graduation_auditMapper;

    @Override
    public List<Graduation_Audit> selectAll() {
        return graduation_auditMapper.selectAll();
    }

}
