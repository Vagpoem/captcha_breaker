package com.example.captcha_breaker.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public JSONObject login(){
        // 进行参数检验

        // 查询数据库

        // 暂时凭证存储 token

        // 返回参数

        return new JSONObject();
    }
}
