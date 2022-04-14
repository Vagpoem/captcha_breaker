package com.example.captcha_breaker.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.captcha_breaker.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {

    @GetMapping("/heartbeat")
    public JSONObject heartBeat(){
        // 查询一些系统指标（AI是否正常、MySQL、Redis 以及 Rabbit MQ 是否正常）

        // 返回查询结果

        return Result.success();
    }
}
