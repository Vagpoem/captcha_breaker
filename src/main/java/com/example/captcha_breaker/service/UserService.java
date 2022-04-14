package com.example.captcha_breaker.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.captcha_breaker.entity.User;
import com.example.captcha_breaker.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectOneByName(String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return userMapper.selectOne(wrapper);
    }

    public User selectOneByEmail(String email){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        return userMapper.selectOne(wrapper);
    }

    public void insertOneUser(User user) throws Exception{
        userMapper.insert(user);
    }
}
