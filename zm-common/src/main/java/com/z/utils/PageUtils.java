package com.z.utils;

import com.github.pagehelper.PageHelper;

import javax.servlet.http.HttpServletRequest;

public class PageUtils {

    public static void setPageInfo(){
        HttpServletRequest request = ServletUtils.getHttpServletRequest();

        int pageNum =Integer.parseInt(StringUtils.requireNonNull(request.getParameter("pageNum")));
        int pageSize =Integer.parseInt(StringUtils.requireNonNull(request.getParameter("pageSize")));

        PageHelper.startPage(pageNum,pageSize);
    }

}
