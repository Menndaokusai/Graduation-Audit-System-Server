package com.example.demo.service;

import com.example.demo.model.Voting_Record;

public interface Voting_RecordService {

    //查询该用户是否投票
    String select(int voteId, String username);

    //创建用户投票记录
    int insert(Voting_Record voting_record);

}
