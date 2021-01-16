package com.z.service.impl;

import com.github.pagehelper.PageHelper;
import com.z.domain.Account;
import com.z.repository.AccountMapper;
import com.z.service.AccountService;
import com.z.service.dto.AccountQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Integer addAccount(Account account){
        int insert = accountMapper.insert(account);
        return account.getId();
    }

    @Override
    public Integer delAccount(Integer id){
        return accountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer changeBalance(Integer id, BigDecimal balance) {

        Account account = new Account();
        account.setId(id);
        account.setBalance(balance);

        return accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public List<Account> getSome(AccountQuery query){
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Account> accounts = accountMapper.selectByKey(query);
        return accounts;
    }

}
