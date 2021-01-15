package com.z.service.impl;

import com.z.domain.Account;
import com.z.repository.AccountMapper;
import com.z.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> getAll(){
        return accountMapper.getAllByAnnotations();
    }

}
