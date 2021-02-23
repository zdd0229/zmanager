package com.z.security.repository;

import com.z.security.domain.SysUser;
import com.z.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class UserDetailsRepository {

    @Autowired
    UserService userService;

    public void createUser(UserDetails user) {

        SysUser sysUser = new SysUser();

        sysUser.setUsername(user.getUsername());
        sysUser.setPassword(user.getPassword());

        userService.createUser(sysUser);
    }

    public void updateUser(UserDetails user) {
        SysUser sysUser = new SysUser();

        sysUser.setUsername(user.getUsername());
        sysUser.setPassword(user.getPassword());

        userService.updateUser(sysUser);
    }

    public void deleteUser(String username) {
        userService.deleteUser(username);
    }

    public void changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext()
                .getAuthentication();

        if (currentUser == null) {
            // This would indicate bad coding somewhere
            throw new AccessDeniedException(
                    "Can't change password as no Authentication object found in context "
                            + "for current user.");
        }

        String username = currentUser.getName();

        UserDetails user = this.loadUserByUsername(username);


        if (user == null) {
            throw new IllegalStateException("Current user doesn't exist in database.");
        }

        // todo copy InMemoryUserDetailsManager  自行实现具体的更新密码逻辑
        if(!Objects.equals(user.getPassword(),oldPassword)){
            throw new IllegalStateException("Current password doesn't  match the password provided");
        }

        SysUser sysUser = new SysUser();

        sysUser.setUsername(user.getUsername());
        sysUser.setPassword(user.getPassword());

        userService.updateUser(sysUser);

    }

    public boolean userExists(String username) {

        return Objects.nonNull(userService.queryByUserName(username));
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = userService.queryByUserName(username);

        if(Objects.nonNull(sysUser)){
            return User.withUsername(sysUser.getUsername()).password(sysUser.getPassword())
                    //todo  这里权限 你需要自己注入
                    .authorities(AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_APP"))
                    .build();
        }

        throw new UsernameNotFoundException("username: " + username + " notfound");
    }
}
