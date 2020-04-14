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
    public List<Punishment> selectAll() {
        return punishmentMapper.selectAll();
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
    public Punishment select(int punishmentId) {
        return punishmentMapper.select(punishmentId);
    }

    @Override
    public int update(Punishment punishment) {
        return punishmentMapper.update(punishment);
    }
}
