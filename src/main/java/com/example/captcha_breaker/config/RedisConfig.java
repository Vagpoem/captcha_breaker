package com.example.captcha_breaker.config;

import com.example.captcha_breaker.util.DefRedisSerializer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@EnableAutoConfiguration
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        // 设置key和value的序列化规则
        redisTemplate.setKeySerializer(DefRedisSerializer.stringRedisSerializer());
        redisTemplate.setValueSerializer(DefRedisSerializer.jackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(DefRedisSerializer.jackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(DefRedisSerializer.jackson2JsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
