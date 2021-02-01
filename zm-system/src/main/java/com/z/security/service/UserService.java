package com.z.security.service;

import com.z.security.domain.SysUser;

public interface UserService {

    boolean checkLogin(String userName, String password);

    SysUser queryByUserName(String username);

    void createUser(SysUser sysUser);

    void updateUser(SysUser sysUser);

    void deleteUser(String username);
}
