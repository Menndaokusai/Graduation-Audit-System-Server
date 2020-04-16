package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.model.Punishment;
import com.example.demo.service.PunishmentService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/punishment")
public class PunishmentController {

    @Autowired
    PunishmentService punishmentService;

    @GetMapping("/list")
    public Object fetchList(){
        List<Object> lists = Collections.singletonList(punishmentService.selectAll());

        return new Message(StatusType.SUCCESS_STATUS,"获取列表成功",lists);
    }


    @PostMapping("/create")
    public Object createPunishment(int studentId, String punishment, String reason, String record_time){

        Punishment ppunishment = new Punishment(0,studentId, punishment,reason, record_time);
        try {
            int result = punishmentService.insert(ppunishment);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
    }

}
