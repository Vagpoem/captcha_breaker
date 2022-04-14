package com.example.captcha_breaker;


import com.example.captcha_breaker.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
public class RedisTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void connectionStringTest(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("user1", "users-token", 5, TimeUnit.SECONDS);
        String value = ops.get("user1");
        log.info("the token of user1 is:"+value);
    }

    @Test
    void connectionRedisTest(){
        ValueOperations ops = redisTemplate.opsForValue();
        User user = new User();
        user.setName("user1");
        ops.set("user1", user, 15, TimeUnit.SECONDS);
        User getUser = (User)ops.get("user1");
        log.info(""+user);
    }

    @Test
    void setTest(){

    }

    @Test
    void getTest(){

    }
}
