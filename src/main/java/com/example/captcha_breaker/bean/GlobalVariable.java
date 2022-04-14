package com.example.captcha_breaker.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class GlobalVariable {
    @Value("${login.token.suffix}")
    private String login_token_suffix;

    @Value("${login.user.suffix}")
    private String login_user_suffix;

    @Value("${retry.times}")
    private int retry_times;
}
