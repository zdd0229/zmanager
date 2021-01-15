package com.z.service;

import com.z.domain.Account;
import com.z.service.dto.AccountQuery;

import java.util.List;

public interface AccountService {
    public List<Account> getSome(AccountQuery query);
}
