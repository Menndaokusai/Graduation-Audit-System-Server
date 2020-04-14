package com.example.demo.service;

import com.example.demo.model.Vote;

import java.util.List;

public interface VoteService {

    //查询所有Vote
    List<Vote> selectAll();

    //增加一个Vote
    int insert(Vote vote);

    //修改一个Vote
    int update(int voteId);

}
