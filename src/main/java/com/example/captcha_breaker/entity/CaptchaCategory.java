package com.example.captcha_breaker.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_captcha_category")
public class CaptchaCategory {

    @TableId(value = "category_code")
    private String category_code;

    @TableField(value = "category_name")
    private String category_name;

    @TableField(value = "category_desc")
    private String category_desc;

    @TableField(value = "points_consume")
    private int points_consume;

    @TableField(value = "update_time")
    private long update_time;
}
