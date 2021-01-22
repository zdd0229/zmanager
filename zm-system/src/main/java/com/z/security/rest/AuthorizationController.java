package com.z.security.rest;

import com.z.exception.BadRequestException;
import com.z.security.service.UserService;
import com.z.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthorizationController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping
    public ResponseEntity login(String userName,String password){

        if(!userService.checkLogin(userName,password)){
            throw new BadRequestException("账号或密码错误");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);

        log.info(String.format("encode:%s",encode));

        String token = "Bearer NKJFDLGHK514";

        redisTemplate.opsForValue().set(token,userName);
        redisTemplate.expire(token,1, TimeUnit.MINUTES);
        return R.create("Bearer NKJFDLGHK514");

    }

}