package com.example.captcha_breaker.service;


import com.alibaba.fastjson.JSONObject;
import com.example.captcha_breaker.bean.GlobalVariable;
import com.example.captcha_breaker.entity.User;
import com.example.captcha_breaker.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Slf4j
@Service
public class RegisterService {

    RedisService redisService;
    UserService userService;
    GlobalVariable globalVariable;

    public RegisterService(UserService userService, RedisService redisService, GlobalVariable globalVariable) {
        this.userService = userService;
        this.redisService = redisService;
        this.globalVariable = globalVariable;
    }

    /*
        注册参数的检验
     */
    public boolean paraCheck(JSONObject req){
        log.info("the req of paraCheck is:"+req);

        String name = req.getString("username");
        String password = req.getString("password");
        String email = req.getString("email");

        // 1.检验空值
        if (name.equals("") || name == null || password.equals("") || password == null || email.equals("") || email == null){
            return false;
        }

        // 2.检验邮箱合法性
        if (!Util.emailCheck(email)){
            return false;
        }

        return true;
    }

    /*
        注册
     */
    public boolean register(JSONObject req){
        log.info("the req of register is:"+req);

        String name = req.getString("username");
        String email = req.getString("email");

        // 1.先查重
        User nameUser = userService.selectOneByName(name);
        User emailUser = userService.selectOneByEmail(email);

        if (nameUser != null || emailUser != null){
            log.error("register user is repeated!");
            return false;
        }

        // 2.生成调用凭证并创建
        UUID call_token = UUID.randomUUID();
        User user = new User();
        user.setName(name);
        user.setPassword(req.getString("password"));
        user.setEmail(email);
        user.setBalance_points(0);
        user.setCall_token(call_token+""+System.currentTimeMillis());

        // 3.向数据库中插入数据
        try {
            userService.insertOneUser(user);
            log.info("after insert user info:"+user);
        } catch (Exception e) {
            log.error("insert into mysql failed!");
            return false;
        }

        // 4.生成登陆状态 token 并保存至 Redis
        try {
            redisService.setToken(name);
            log.info("insert login_token into redis success! login_token:"+redisService.getToken(name));
        } catch (Exception e) {
            log.error("insert login_token into redis failed!");
        }

        // 5.将用户数据放至缓存
        try {
            redisService.setObject(name+globalVariable.getLogin_user_suffix(), user);
            log.info("insert login user into redis:"+user);
        } catch (Exception e) {
            log.error("insert login user into redis error!");
        }

        // 6.返回结果
        return true;
    }
}
