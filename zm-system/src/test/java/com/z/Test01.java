package com.z;

import com.z.repository.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void testDao(){
    }

}
