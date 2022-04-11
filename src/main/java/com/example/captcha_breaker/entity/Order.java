package com.example.captcha_breaker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_order")
public class Order {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField(value = "user_id")
    private int user_id;

    @TableField(value = "top_up_time")
    private long top_up_time;

    @TableField(value = "top_up_points")
    private int top_up_points;

    @TableField(value = "flag")
    private String flag;
}
