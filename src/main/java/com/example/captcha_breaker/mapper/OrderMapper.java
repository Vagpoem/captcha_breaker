package com.example.captcha_breaker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.captcha_breaker.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
