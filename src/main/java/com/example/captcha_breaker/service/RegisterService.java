package com.example.captcha_breaker.service;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.captcha_breaker.entity.User;
import com.example.captcha_breaker.mapper.UserMapper;
import com.example.captcha_breaker.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class RegisterService {

    @Autowired
    UserMapper userMapper;

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
        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("name", name);
        User nameUser = userMapper.selectOne(wrapper1);

        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("email", email);
        User emailUser = userMapper.selectOne(wrapper2);

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
        int res = 0;
        try {
            res = userMapper.insert(user);
        } catch (Exception e) {
            log.error("insert into mysql failed!");
            return false;
        }

        // 4.返回是否成功
        if (res == 1) {
            log.info("insert into mysql success!");
            return true;
        } else {
            log.error("insert into mysql failed!");
            return false;
        }
    }
}
