package com.example.demo.controller;

import com.example.demo.model.Honour;
import com.example.demo.model.Message;
import com.example.demo.model.PageList;
import com.example.demo.service.HonourService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/honour")
public class HonourController {

    @Autowired
    HonourService honourService;

    @GetMapping("/list")
    public Object fetchList(String studentId,int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(honourService.selectAll(start,limit));
        }
        else{
            lists = Collections.singletonList(honourService.selectBysId(studentId,start,limit));
        }
        int total=lists.size();
        return new PageList(StatusType.SUCCESS_STATUS,total,lists);
    }

    @GetMapping("/detail")
    public Object fetchHonour(int honourId){
        List<Object> lists = Collections.singletonList(honourService.select(honourId));

        return new Message(StatusType.SUCCESS_STATUS,"获取详情成功",lists);
    }

    @PostMapping("/create")
    public Object createHonour(@RequestBody Honour honour){

        String record_time = DateUtils.getDate();
        honour.setRecord_time(record_time);

        try {
            int result = honourService.insert(honour);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
    }

    @PostMapping("/update")
    public Object updateHonour(int honourId, String studentId, String honour, String obtain_time, String record_time){

        Honour hhonour = new Honour(honourId,studentId,honour,obtain_time,record_time);

        try{
            int result = honourService.update(hhonour);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"更新失败");
    }

}
