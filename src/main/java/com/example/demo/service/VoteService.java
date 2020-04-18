package com.example.demo.service;

import com.example.demo.model.Vote;

import java.util.List;

public interface VoteService {

    //查询所有Vote
    List<Vote> selectAll(int start,int limit);

    //查询该学生的Vote
    List<Vote> selectBysId(String studentId,int start,int limit);

    //增加一个Vote
    int insert(Vote vote);

    //修改一个Vote
    int update(Vote vote);

}
