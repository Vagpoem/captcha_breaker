package com.example.captcha_breaker.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.captcha_breaker.service.AccountService;
import com.example.captcha_breaker.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/topup")
    public JSONObject topUp(@RequestBody JSONObject req){
        // 1.进行参数检验
        if (!accountService.checkPara(req)) {
            return Result.fail();
        }

        // 2.进行充值 这里需要使用事务
        if (!accountService.topUp(req)){
            return Result.fail();
        }

        // 3.返回充值是否成功
        return Result.success();
    }
}
