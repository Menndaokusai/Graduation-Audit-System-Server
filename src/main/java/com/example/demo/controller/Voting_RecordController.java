package com.example.demo.controller;

import com.example.demo.service.Voting_RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class Voting_RecordController {

    @Autowired
    Voting_RecordService voting_recordService;

}
