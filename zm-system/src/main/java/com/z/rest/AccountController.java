package com.z.rest;

import com.z.domain.Account;
import com.z.domain.vo.AccountVo;
import com.z.service.AccountService;
import com.z.utils.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<AccountVo> getAll(){
        List<Account> all = accountService.getAll();
        return BeanCopierUtils.copyList(Account.class, AccountVo.class,all);
    }

}
