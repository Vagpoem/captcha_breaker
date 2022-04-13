package com.example.captcha_breaker.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @PostMapping("/logout")
    public JSONObject logout(){
        // 进行参数检验

        // 查询是否已退出

        // 销毁 token

        // 返回结果

        return new JSONObject();
    }
}
