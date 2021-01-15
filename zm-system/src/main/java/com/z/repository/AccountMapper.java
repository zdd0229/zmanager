package com.z.repository;


import com.z.domain.Account;
import com.z.service.dto.AccountQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectByKey(AccountQuery query);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}