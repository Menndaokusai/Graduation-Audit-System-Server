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
    public List<Vote> selectAll(int start,int limit) {
        return voteMapper.selectAll(start, limit);
    }

    @Override
    public List<Vote> selectBysId(String studentId, int start, int limit) {
        return voteMapper.selectBysId(studentId,start,limit);
    }

    @Override
    public Vote selectVote(int voteId) {
        return voteMapper.selectVote(voteId);
    }

    @Override
    public int insert(Vote vote) {
        return voteMapper.insert(vote);
    }

    @Override
    public int update(Vote vote) {
        return voteMapper.update(vote);
    }

    @Override
    public int agree(int voteId) {
        return voteMapper.agree(voteId);
    }

    @Override
    public int disagree(int voteId) {
        return voteMapper.disagree(voteId);
    }
}
