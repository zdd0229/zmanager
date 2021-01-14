package com.z.controller;

import com.z.exception.MyException;
import com.z.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Map<String, Object>> getAll(){
        List<Map<String, Object>> all = accountService.getAll();
        if (all.size()==0){
            throw new MyException("无数据");
        }
        return all;
    }

}
