package com.example.captcha_breaker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_job")
public class Job {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField(value = "src_type")
    private String src_type;

    @TableField(value = "start_time")
    private long start_time;

    @TableField(value = "end_time")
    private long end_time;

    @TableField(value = "path")
    private String path;

    @TableField(value = "category_code")
    private String category_code;

    @TableField(value = "call_id")
    private int call_id;

    @TableField(value = "finish_id")
    private int finish_id;

    @TableField(value = "bypass_result")
    private String bypass_result;

    @TableField(value = "response_code")
    private String response_code;

    @TableField(value = "flag")
    private String flag;

    @TableField(exist = false)
    private String temp_id;
}
