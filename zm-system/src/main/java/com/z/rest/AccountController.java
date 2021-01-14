package com.z.rest;

import com.z.exception.BadRequestException;
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
            throw new BadRequestException("无数据");
        }
        return all;
    }

}
