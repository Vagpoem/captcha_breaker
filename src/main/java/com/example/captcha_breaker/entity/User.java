package com.example.captcha_breaker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "password")
    private String password;

    @TableField(value = "email")
    private String email;

    @TableField(value = "call_token")
    private String call_token;

    @TableField(value = "balance_points")
    private int balance_points;

    @TableField(exist = false)
    private String temp_token;
}
