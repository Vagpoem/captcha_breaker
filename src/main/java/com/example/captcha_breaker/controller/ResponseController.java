package com.example.captcha_breaker.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @PostMapping("/response")
    public JSONObject response(){
        // 进行参数检验

        // 查询是否为正确任务

        // 进行反馈

        // 返回结果

        return new JSONObject();
    }
}
