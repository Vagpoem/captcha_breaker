package com.example.captcha_breaker;


import com.example.captcha_breaker.entity.User;
import com.example.captcha_breaker.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SqlTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void userInsert(){
        User user = new User();
        user.setName("user2");
        user.setPassword("123");
        user.setBalance_points(0);
        user.setEmail("user2@cp.com");
        user.setCall_token("user2");

        int result = userMapper.insert(user);
        if (result == 1){
            log.info("insert user success!");
        } else {
            log.error("insert user failed!");
        }
    }

    @Test
    void userDelete(){

    }

    @Test
    void userUpdate(){

    }

    @Test
    void userQuery(){}

}
