package com.example.demo.service;


import com.example.demo.mapper.PunishmentMapper;
import com.example.demo.model.Punishment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunishmentServiceImpl implements PunishmentService{

    @Autowired
    PunishmentMapper punishmentMapper;

    @Override
    public String punishmentTime(String studentId) {
        return punishmentMapper.punishmentTime(studentId);
    }

    @Override
    public List<Punishment> selectAll(int start,int limit) {
        return punishmentMapper.selectAll(start, limit);
    }

    @Override
    public int insert(Punishment punishment) {
        return punishmentMapper.insert(punishment);
    }

    @Override
    public int delete(int punishmentId) {
        return punishmentMapper.delete(punishmentId);
    }

    @Override
    public Punishment select(int studentId) {
        return punishmentMapper.select(studentId);
    }

    @Override
    public int update(Punishment punishment) {
        return punishmentMapper.update(punishment);
    }
}
