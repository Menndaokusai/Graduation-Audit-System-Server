package com.example.demo.controller;


import com.example.demo.utils.Message;
import com.example.demo.utils.PageList;
import com.example.demo.model.Punishment;
import com.example.demo.service.PunishmentService;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/punishment")
public class PunishmentController {

    @Autowired
    PunishmentService punishmentService;

    @GetMapping("/list")
    public Object fetchList(String studentId,int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(punishmentService.selectAll(start,limit));
        }
        else{
            lists = Collections.singletonList(punishmentService.select(Integer.parseInt(studentId)));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }


    @PostMapping("/create")
    public Object createPunishment(@RequestBody Punishment punishment){

        String record_time = DateUtils.getDate();

        punishment.setRecord_time(record_time);

        try {
            int result = punishmentService.insert(punishment);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
    }

}
