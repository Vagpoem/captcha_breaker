package com.example.captcha_breaker.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @PostMapping("/logout")
    public void logout(){
        // 进行参数检验

        // 查询是否已退出

        // 销毁 token

        // 返回结果
    }
}
