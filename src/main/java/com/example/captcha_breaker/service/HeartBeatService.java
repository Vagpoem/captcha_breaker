package com.example.captcha_breaker.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.captcha_breaker.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HeartBeatService {

    UserService userService;
    RedisService redisService;

    public HeartBeatService(UserService userService, RedisService redisService){
        this.userService = userService;
        this.redisService = redisService;
    }

    public boolean databaseTest(){
        String email = "testUser@cp.com";
        String name = "testUser";

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);

        try {
            User user = userService.selectOneByName(name);
            log.info("mysql connection is running!");
            return true;
        } catch (Exception e) {
            log.error("mysql connection error!");
            return false;
        }
    }

    public boolean redisTest(){
        String key = "testUser";
        String value = "testUserValue";

        try {
            redisService.setString(key, value);
            log.info("redis connection is running");
            return true;
        } catch (Exception e) {
            log.error("redis error!");
            return false;
        }
    }
}
