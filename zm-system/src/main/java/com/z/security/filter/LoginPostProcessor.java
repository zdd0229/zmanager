package com.z.security.filter;

import com.z.security.domain.enumeration.LoginTypeEnum;

import javax.servlet.ServletRequest;

public interface LoginPostProcessor {
    /**
     * 获取 登录类型
     *
     * @return the type
     */
    LoginTypeEnum getLoginTypeEnum();

    /**
     * 获取用户名
     *
     * @param request the request
     * @return the string
     */
    String obtainUsername(ServletRequest request);

    /**
     * 获取密码
     *
     * @param request the request
     * @return the string
     */
    String obtainPassword(ServletRequest request);

}
