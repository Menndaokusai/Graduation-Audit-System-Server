package com.example.demo.service;


import com.example.demo.mapper.VoteMapper;
import com.example.demo.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{

    @Autowired
    VoteMapper voteMapper;

    @Override
    public List<Vote> selectAll() {
        return voteMapper.selectAll();
    }

    @Override
    public int insert(Vote vote) {
        return voteMapper.insert(vote);
    }

    @Override
    public int update(Vote vote) {
        return voteMapper.update(vote);
    }
}
