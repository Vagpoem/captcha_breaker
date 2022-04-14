package com.example.captcha_breaker.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.captcha_breaker.bean.GlobalVariable;
import com.example.captcha_breaker.service.LoginService;
import com.example.captcha_breaker.service.RedisService;
import com.example.captcha_breaker.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    LoginService loginService;
    RedisService redisService;
    GlobalVariable globalVariable;

    public LoginController(LoginService loginService, RedisService redisService, GlobalVariable globalVariable) {
        this.loginService = loginService;
        this.redisService = redisService;
        this.globalVariable = globalVariable;
    }

    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject req){
        // 进行参数检验
        if (!loginService.checkPara(req)) {
            return Result.fail();
        }

        // 进行登录操作
        if (!loginService.login(req)) {
            return Result.fail();
        }

        // 暂时凭证存储 token
        JSONObject res = Result.success();
        try {
            res.put("token", redisService.getString(req.getString("username")+globalVariable.getLogin_token_suffix()));
        } catch (Exception e) {
            log.error("get login token failed!");
            return Result.fail();
        }

        // 返回参数
        return res;
    }
}
