package com.example.captcha_breaker.service;

import com.alibaba.fastjson.JSONObject;
import com.example.captcha_breaker.bean.GlobalVariable;
import com.example.captcha_breaker.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class LoginService {

    UserService userService;
    RedisService redisService;
    GlobalVariable globalVariable;

    public LoginService(UserService userService, RedisService redisService, GlobalVariable globalVariable) {
        this.userService = userService;
        this.redisService = redisService;
        this.globalVariable = globalVariable;
    }

    /**
     * 参数检验函数
     * @param req
     * @return
     */
    public boolean checkPara(JSONObject req){

        String name = req.getString("username");
        String password = req.getString("password");

        // 1.判断空值
        if (name.equals("") || name == null || password.equals("") || password == null) {
            return false;
        }

        return true;
    }

    /**
     * 登陆函数
     * @param req
     * @return
     */
    public boolean login(JSONObject req){

        String name = req.getString("username");
        String password = req.getString("password");

        // 1.检查用户是否存在
        User user = userService.selectOneByName(name);
        if (user == null) {
            return false;
        }

        // 2.检查密码是否正确
        if (!password.equals(user.getPassword())) {
            return false;
        }
        log.info("the login user:"+user);

        // 3.生成登录 token
        try {
            redisService.setToken(req.getString("username"));
            log.info("the login user's token:"+redisService.getToken(req.getString("username")));
        } catch (Exception e) {
            log.error("login user token insert error!");
        }

        // 4.将用户数据放至缓存
        try {
            redisService.setObject(name+globalVariable.getLogin_user_suffix(), user);
            log.info("insert the login user into redis:"+user);
        } catch (Exception e) {
            log.error("insert the login user into redis error!");
        }

        return true;
    }
}
