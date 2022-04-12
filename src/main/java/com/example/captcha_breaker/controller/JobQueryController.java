package com.example.captcha_breaker.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobQueryController {

    @PostMapping("/getOneJob")
    public void getOneJob(){
        // 进行参数检验

        // 查询一个任务 设置缓存机制

        // 返回查询结果
    }

    @PostMapping("/getJobList")
    public void getJobList(){
        // 进行参数检验

        // 查询任务列表

        // 返回查询结果
    }

    @PostMapping("/getJobPage")
    public void getJobPage(){
        // 进行参数检验

        // 进行分页操作

        // 返回查询结果
    }
}
