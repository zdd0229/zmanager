package com.z.security.rest;

import com.z.exception.BadRequestException;
import com.z.security.service.UserService;
import com.z.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthorizationController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity login(String userName,String password){

        if(!userService.checkLogin(userName,password)){
            throw new BadRequestException("账号或密码错误");
        }

        return R.create("Bearer NKJFDLGHK514");

    }

}