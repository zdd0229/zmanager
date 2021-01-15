package com.z;

import com.z.domain.Account;
import com.z.repository.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void testDao(){
        List<Account> all1 = accountMapper.getAllByAnnotations();
        System.out.println(all1);
        List<Account> all2 = accountMapper.getAllByXml();
        System.out.println(all2);
    }

}
