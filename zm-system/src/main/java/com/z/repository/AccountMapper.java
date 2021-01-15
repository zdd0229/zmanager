package com.z.repository;
import com.z.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccountMapper {

    @Select("select * from account")
    List<Account> getAllByAnnotations();

    List<Account> getAllByXml();

    public int insert(Account account);

}
