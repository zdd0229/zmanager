package com.z.security.service.impl;

import com.z.security.domain.SysUser;
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

    @Override
    public SysUser queryByUserName(String username) {

        return sysUserMapper.queryByUserName(username);

    }

    @Override
    public void createUser(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void updateUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void deleteUser(String username) {
        sysUserMapper.deleteByPrimaryKey(username);
    }
}
