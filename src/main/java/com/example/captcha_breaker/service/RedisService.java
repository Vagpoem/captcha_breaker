package com.example.captcha_breaker.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisService {

    @Value("${string.value.timeout}")
    int STRING_VALUE_TIME_OUT;
    @Value("${object.value.timeout}")
    int OBJECT_VALUE_TIME_OUT;

    StringRedisTemplate stringRedisTemplate;
    RedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate stringRedisTemplate, RedisTemplate redisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisTemplate = redisTemplate;
    }

    public void setString(String key, String value) throws Exception{
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value, STRING_VALUE_TIME_OUT, TimeUnit.SECONDS);
    }

    public String getString(String key) throws Exception{
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get(key);
    }

    public void setObject(Object key, Object value) throws Exception{
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set(key, value, OBJECT_VALUE_TIME_OUT, TimeUnit.SECONDS);
    }

    public Object getObject(Object key){
        ValueOperations ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

}
