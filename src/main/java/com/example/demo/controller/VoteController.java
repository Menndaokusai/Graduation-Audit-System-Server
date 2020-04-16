package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.model.Vote;
import com.example.demo.service.VoteService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;


    @GetMapping("/list")
    public Object fetchList(){

        List<Object> votes = Collections.singletonList(voteService.selectAll());

        return new Message(StatusType.SUCCESS_STATUS,"获取投票列表成功",votes);
    }

    @PostMapping("/create")
    public Object createVote(int studentId,
                             Integer agree, Integer disagree,
                             String voting_results, String publish_time,
                             String deadline){

        Vote vote = new Vote(0,studentId,agree,disagree,voting_results,publish_time,deadline);
        try {
            int result = voteService.insert(vote);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建投票成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建投票失败");
    }


    @PostMapping("/update")
    public Object updateVote(int voteId, int studentId,
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
