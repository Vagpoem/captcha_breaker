package com.example.captcha_breaker.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.captcha_breaker.service.RegisterService;
import com.example.captcha_breaker.util.Result;
import com.example.captcha_breaker.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public JSONObject register(@RequestBody JSONObject req){
        // 1.传入参数 进行检验
        if (!registerService.paraCheck(req)) {
            return Result.fail();
        }

        // 2.进行注册插入操作
        if (registerService.register(req)) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
}
