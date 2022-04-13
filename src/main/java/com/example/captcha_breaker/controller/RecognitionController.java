package com.example.captcha_breaker.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecognitionController {

    @PostMapping("/recognition")
    public JSONObject recognition(){
        // 进行参数检验

        // 分配全局唯一 ID

        // 进行分类（数据驱动？）

        // 数据驱动的分发给人和 AI ？（AI 可解、人工可解已经二者都不可解加入专家？）

        // 推送给人工或是三方又或是 AI 并阻塞

        // 得到信号并返回结果

        return new JSONObject();
    }
}
