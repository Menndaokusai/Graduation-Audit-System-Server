package com.example.demo.controller;


import com.example.demo.model.Voting_Record;
import com.example.demo.service.Voting_RecordService;
import com.example.demo.utils.Message;
import com.example.demo.utils.PageList;
import com.example.demo.model.Vote;
import com.example.demo.service.VoteService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;

    @Autowired
    Voting_RecordService voting_recordService;


    @GetMapping("/list")
    public Object fetchList(String studentId,int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(voteService.selectAll(start,limit));
        }
        else {
            lists = Collections.singletonList(voteService.selectBysId(studentId,start,limit));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }

    @PostMapping("/create")
    public Object createVote(@RequestBody Vote vote){
        String publish_time = DateUtils.getDate();
        vote.setVoteId(0);
        vote.setAgree(0);
        vote.setDisagree(0);
        vote.setVoting_results("1");
        vote.setPublish_time(publish_time);
        try {
            int result = voteService.insert(vote);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
    }


    @PostMapping("/update")
    public Object updateVote(@RequestBody Voting_Record voting_record){

        int result = 0;
        int voteId=voting_record.getVoteId();
        try {
            String voting_result = voting_recordService.select(voteId,voting_record.getUsername());
            //检验是否已投票
            if(voting_result.equals("0")){
                if(voting_record.getNum()==1){
                    result=voteService.agree(voteId);
                }
                else if (voting_record.getNum()==2){
                    result=voteService.disagree(voteId);
                }

                //检验投票结果
                Vote vote = voteService.selectVote(voteId);
                double participant=vote.getParticipant();
                double agree = vote.getAgree();
                double disagree = vote.getDisagree();
                //同意人数占比
                double proportion = agree/participant;

                if((agree+disagree)==participant){
                    if(proportion>(1.0/2.0)){
                        vote.setVoting_results("2");
                    }
                    else {
                        vote.setVoting_results("-1");
                    }
                    //更新投票结果
                    voteService.update(vote);
                }

                if(result>0){
                    //添加投票记录
                    voting_recordService.insert(voting_record);

                    return new Message(StatusType.SUCCESS_STATUS,"更新成功");
                }
                return new Message(StatusType.ERROR_STATUS,"更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(StatusType.ERROR_STATUS,"请勿重复投票");
    }


}
