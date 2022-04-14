package com.example.captcha_breaker.service;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.captcha_breaker.bean.GlobalVariable;
import com.example.captcha_breaker.entity.User;
import com.example.captcha_breaker.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountService {

    UserMapper userMapper;
    RedisService redisService;
    GlobalVariable globalVariable;

    public AccountService(UserMapper userMapper, RedisService redisService, GlobalVariable globalVariable){
        this.userMapper = userMapper;
        this.redisService = redisService;
        this.globalVariable = globalVariable;
    }

    public boolean checkPara(JSONObject req){
        String name = req.getString("username");
        int points = req.getInteger("top_up_points");
        String token = req.getString("token");

        if (name.equals("") || name == null || points <= 0 || token.equals("") || token == null){
            return false;
        }

        return true;
    }

    public boolean topUp(JSONObject req){
        String name = req.getString("username");
        int points = req.getInteger("top_up_points");
        String token = req.getString("token");

        // 1.检查用户是否合法
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        User user = userMapper.selectOne(queryWrapper);

        if (user == null){
            return false;
        }

        // 2.检查用户 token
        if (!redisService.checkToken(name, token)){
            return false;
        }

        // 3.更新数据库
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", name).set("balance_points", user.getBalance_points()+points);
        for (int i = 0; i < globalVariable.getRetry_times(); i++) {
            try {
                userMapper.update(null, updateWrapper);
                log.info("user "+name+" top up success update database success!");
                break;
            } catch (Exception e) {
                log.error("user "+name+" top up success update database failed!");
            }
        }

        return true;
    }
}
