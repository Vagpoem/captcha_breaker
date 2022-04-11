package com.example.captcha_breaker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.captcha_breaker.entity.CaptchaCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CaptchaCategoryMapper extends BaseMapper<CaptchaCategory> {
}
