package com.example.captcha_breaker.util;

import com.alibaba.fastjson.JSONObject;

public class Result {

    /*
        返回请求成功对象
     */
    public static JSONObject success(){
        JSONObject success = new JSONObject();
        success.put("status", "200");
        success.put("message", "request success");
        return success;
    }

    /*
        返回请求失败对象
     */
    public static JSONObject fail(){
        JSONObject fail = new JSONObject();
        fail.put("status", "201");
        fail.put("message", "request failed");
        return fail;
    }

    /*
        返回服务器错误对象
     */
    public static JSONObject serverError(){
        JSONObject serverError = new JSONObject();
        serverError.put("status", "500");
        serverError.put("message", "Server Error");
        return serverError;
    }

}
