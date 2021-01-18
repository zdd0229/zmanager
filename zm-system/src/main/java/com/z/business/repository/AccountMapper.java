package com.z.business.repository;


import com.z.business.domain.entity.Account;
import com.z.business.domain.query.AccountQuery;
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