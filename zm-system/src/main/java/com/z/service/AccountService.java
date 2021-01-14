package com.z.service;

import com.z.repository.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public List<Map<String,Object>> getAll(){
        return accountMapper.getAllByAnnotations();
    }

}
