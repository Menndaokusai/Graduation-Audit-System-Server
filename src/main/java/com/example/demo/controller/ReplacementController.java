package com.example.demo.controller;


import com.example.demo.utils.Message;
import com.example.demo.utils.PageList;
import com.example.demo.model.Replacement;
import com.example.demo.service.ReplacementService;
import com.example.demo.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/replacement")
public class ReplacementController {

    @Autowired
    ReplacementService replacementService;

    @GetMapping("/list")
    public Object fetchList(String studentId, int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(studentId==null||studentId.equals("")){
            lists = Collections.singletonList(replacementService.selectAll(start,limit));
        }
        else {
            lists = Collections.singletonList(replacementService.selectBystudentId(studentId,start,limit));
        }

        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }

    @GetMapping("/detail")
    public Object fetchReplacement(int replacementId){
        List<Object> lists = Collections.singletonList(replacementService.selectByreplacementId(replacementId));

        return new Message(StatusType.SUCCESS_STATUS,"获取详情成功",lists);
    }

    @PostMapping("/create")
    public Object createReplacement(@RequestBody Replacement replacement){

        replacement.setReplacementId(0);

        try {
            int result = replacementService.insert(replacement);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建失败");
    }

    @PostMapping("/update")
    public Object updateReplacement(@RequestBody Replacement replacement){

        try{
            int result = replacementService.update(replacement);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"更新失败");
    }

}
