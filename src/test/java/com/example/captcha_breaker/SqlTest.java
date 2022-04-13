package com.example.captcha_breaker;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.captcha_breaker.entity.User;
import com.example.captcha_breaker.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@Slf4j
@SpringBootTest
public class SqlTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void userInsert(){
        // 数据库插入测试
        User user = new User();
        user.setId(1);
        user.setName("user1");
        user.setPassword("123");
        user.setBalance_points(0);
        user.setEmail("user1@cp.com");
        user.setCall_token("user1");

        int result = userMapper.insert(user);
        if (result == 1){
            log.info("insert user success!");
        } else {
            log.error("insert user failed!");
        }
    }

    @Test
    void userDelete(){
        // 根据主键进行删除
        int result = userMapper.deleteById(1);
        log.info("the result of delete is :"+result);
        if (result == 1) {
            log.info("delete success!");
        } else {
            log.info("delete failed!");
        }

        // 根据主键进行批量删除
        int row = userMapper.deleteBatchIds(Arrays.asList(3, 4, 5, 6));
        log.info("delete "+row+" rows");

        // 根据条件利用 map 进行批量删除
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "user1");
        int rows = userMapper.deleteByMap(map);
        log.info("delete rows :"+rows);

        // 根据条件利用 Wrapper 进行删除
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "user1").eq("email", "user1@cp.com");
        int deleteResult = userMapper.delete(wrapper);
        log.info("the result is:"+deleteResult);
    }

    @Test
    void userUpdate(){
        // 通过 id 进行修改
        User user = new User();
        user.setName("user2");
        user.setId(2);
        int res1 = userMapper.updateById(user);
        log.info("the res is :"+res1);

        // 通过 wrapper 进行修改
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "user1").set("id", 1);
        int res2 = userMapper.update(null, wrapper);

        // 通过实体类进行修改
        UpdateWrapper<User> wrapper1 = new UpdateWrapper<>();
        wrapper1.eq("name", "user1");
        User user1 = new User();
        user1.setEmail("2022user1@cp.com");
        // 无法修改主键？
        user1.setId(3);
        int res3 = userMapper.update(user1, wrapper1);
    }

    @Test
    void userQuery(){
        // 通过 id 进行筛选
        User byId = userMapper.selectById(1);
        log.info("select by ID:"+byId.toString());

        // 通过条件选择一个
        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("name", "user1");
        User user1 = userMapper.selectOne(wrapper1);
        log.info("select one:"+user1.toString());

        // 通过条件 wrapper 进行筛选多个对象
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.like("name", "er");
        List<User> list = userMapper.selectList(wrapper2);
        log.info("select list:"+list.toString());

        // 通过条件 wrapper 进行筛选多个对象
        QueryWrapper<User> wrapper3 = new QueryWrapper<>();
        wrapper3.orderByAsc("id");
        List<Map<String, Object>> mapList1 = userMapper.selectMaps(wrapper3);
        log.info("select map order list:"+mapList1.toString());

        // 通过条件 wrapper 进行筛选多个对象
        QueryWrapper<User> wrapper4 = new QueryWrapper<>();
        wrapper4.orderBy(true, false, "id");
        List<User> list1 = userMapper.selectList(wrapper4);
        log.info("select order list:"+list1.toString());
    }

    @Test
    void selectOneTest(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "user3");
        User user = userMapper.selectOne(wrapper);
        if (user == null){
            log.info("user is null!");
        } else {
            log.info("user is not null!");
        }
    }

}
