package com.example.captcha_breaker.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_response_code")
public class ResponseCode {

    @TableId(value = "response_code")
    private String response_code;

    @TableField(value = "response_desc")
    private String response_desc;

    @TableField(value = "update_time")
    private long update_time;
}
