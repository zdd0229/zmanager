package com.z.business.service;


import com.z.business.domain.entity.Account;
import com.z.business.domain.query.AccountQuery;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    Integer addAccount(Account account);

    Integer delAccount(Integer id);

    List<Account> getSome(AccountQuery query);

    Integer changeBalance(Integer id, BigDecimal balance);
}
