package com.z.business.service.impl;

import com.z.business.domain.entity.Account;
import com.z.business.domain.query.AccountQuery;
import com.z.business.repository.AccountMapper;
import com.z.business.service.AccountService;
import com.z.utils.PageUtils;
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

        PageUtils.setPageInfo();
        List<Account> accounts = accountMapper.selectByKey(query);
        return accounts;

    }

}
