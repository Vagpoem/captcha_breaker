package com.example.captcha_breaker.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobQueryController {

    @PostMapping("/getOneJob")
    public JSONObject getOneJob(){
        // 进行参数检验

        // 查询一个任务 设置缓存机制

        // 返回查询结果

        return new JSONObject();
    }

    @PostMapping("/getJobList")
    public JSONObject getJobList(){
        // 进行参数检验

        // 查询任务列表

        // 返回查询结果

        return new JSONObject();
    }

    @PostMapping("/getJobPage")
    public JSONObject getJobPage(){
        // 进行参数检验

        // 进行分页操作

        // 返回查询结果

        return new JSONObject();
    }
}
