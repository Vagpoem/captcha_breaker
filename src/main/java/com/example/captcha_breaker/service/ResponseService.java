package com.example.captcha_breaker.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResponseService {

    JobService jobService;

    public ResponseService(JobService jobService){
        this.jobService = jobService;
    }

    public boolean checkPara(JSONObject req){
        return true;
    }

    public boolean response(JSONObject req){
        return true;
    }
}
