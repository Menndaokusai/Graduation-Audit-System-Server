package com.example.demo.controller;


import com.example.demo.model.Graduation_Audit;
import com.example.demo.model.Message;
import com.example.demo.model.PageList;
import com.example.demo.model.Vote;
import com.example.demo.service.VoteService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;


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
        int total=lists.size();
        return new PageList(StatusType.SUCCESS_STATUS,total,lists);
    }

    @PostMapping("/create")
    public Object createVote(@RequestBody Vote vote){
        String publish_time = DateUtils.getDate();
        vote.setVoteId(0);
        vote.setAgree(0);
        vote.setDisagree(0);
        vote.setVoting_results("审核中");
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
    public Object updateVote(int voteId, String studentId,
                             int agree, int disagree,
                             String voting_results, String publish_time,
                             String deadline){

        Vote vote = new Vote(voteId,studentId,agree,disagree,voting_results,publish_time,deadline);

        try{
            int result = voteService.update(vote);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"更新失败");
    }


}
