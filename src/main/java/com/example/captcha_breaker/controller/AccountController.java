package com.example.captcha_breaker.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping("/topup")
    public void topUp(){
        // 进行参数检验

        // 进行充值 这里需要使用事务

        // 返回充值是否成功
    }
}
