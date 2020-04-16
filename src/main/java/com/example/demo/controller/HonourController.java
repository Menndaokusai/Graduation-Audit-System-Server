package com.example.demo.controller;

import com.example.demo.model.Honour;
import com.example.demo.model.Message;
import com.example.demo.service.HonourService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/honour")
public class HonourController {

    @Autowired
    HonourService honourService;

    @GetMapping("/list")
    public Object fetchList(){
        List<Object> lists = Collections.singletonList(honourService.selectAll());

        return new Message(StatusType.SUCCESS_STATUS,"获取列表成功",lists);
    }

    @GetMapping("/detail")
    public Object fetchHonour(int honourId){
        List<Object> lists = Collections.singletonList(honourService.select(honourId));

        return new Message(StatusType.SUCCESS_STATUS,"获取详情成功",lists);
    }

    @PostMapping("/create")
    public Object createHonour(int studentId, String honour, String obtain_time, String record_time){

        Honour hhonour = new Honour(0,studentId,honour,obtain_time,record_time);
        try {
            int result = honourService.insert(hhonour);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
    }

    @PostMapping("/update")
    public Object updateHonour(int honourId, int studentId, String honour, String obtain_time, String record_time){

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
