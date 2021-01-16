package com.z.service;

import com.z.domain.Account;
import com.z.service.dto.AccountQuery;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    Integer addAccount(Account account);

    Integer delAccount(Integer id);

    List<Account> getSome(AccountQuery query);

    Integer changeBalance(Integer id, BigDecimal balance);
}
