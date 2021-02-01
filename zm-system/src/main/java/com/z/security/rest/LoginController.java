package com.z.security.rest;

import com.z.security.domain.SysUser;
import com.z.security.service.UserService;
import com.z.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登陆失败，返回401 提示登录失败
     * @return
     */
    @RequestMapping("failure")
    public ResponseEntity loginFail(){
        return R.create("登录失败", HttpStatus.UNAUTHORIZED);
    }

    /**
     * 登录成功 返回用户信息
     */
    @RequestMapping("success")
    public ResponseEntity loginSuccess(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        SysUser sysUser = userService.queryByUserName(username);
        //脱敏
        sysUser.setPassword("[PROTECT]");
        return R.create(sysUser);
    }

}
