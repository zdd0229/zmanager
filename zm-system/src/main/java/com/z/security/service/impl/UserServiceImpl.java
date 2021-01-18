package com.z.security.service.impl;

import com.z.security.repository.SysUserMapper;
import com.z.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public boolean checkLogin(String userName, String password) {

        return sysUserMapper.checkLogin(userName,password)==1;

    }
}
