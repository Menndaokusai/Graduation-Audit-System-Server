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

    @Override
    public List<Graduation_Audit> LimitedSelectAll(int start,int limit) {
        return graduation_auditMapper.LimitedSelectAll(start,limit);
    }

    @Override
    public List<Graduation_Audit> selectBysId(String studentId) {
        return graduation_auditMapper.selectBysId(studentId);
    }

    @Override
    public int insert(String studentId, String studentName, String studentClass) {
        return graduation_auditMapper.insert(studentId, studentName, studentClass);
    }

    @Override
    public int updateAuditData(String studentId,double accum_credit,
                               double average_score,double relearn_time,
                               double punishment_time) {
        return graduation_auditMapper.updateAuditData(studentId, accum_credit,
                                                      average_score, relearn_time,
                                                      punishment_time);
    }

    @Override
    public int updateCertificate(String studentId, String graduation, String degree) {
        return graduation_auditMapper.updateCertificate(studentId, graduation, degree);
    }

}
