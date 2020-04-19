package com.example.demo.service;

import com.example.demo.mapper.Voting_RecordMapper;
import com.example.demo.model.Voting_Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Voting_RecordServiceImpl implements Voting_RecordService{

    @Autowired
    Voting_RecordMapper voting_recordMapper;


    @Override
    public String select(int voteId, String username) {
        return voting_recordMapper.select(voteId,username);
    }

    @Override
    public int insert(Voting_Record voting_record) {
        return voting_recordMapper.insert(voting_record);
    }
}
