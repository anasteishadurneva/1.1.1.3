package com.bank.history.back.feign;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User getUserById(Long id) {
        return null;
    }
}