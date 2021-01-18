package com.z.utils;

import com.z.exception.BadRequestException;
import org.springframework.lang.Nullable;

public class StringUtils {

    public static String requireNonNull(String s)  {
        if(isEmpty(s)){
            throw new BadRequestException("String不能为null或\"\"");
        }
        return s;
    }

    public static boolean isEmpty(@Nullable Object str) {
        return (str == null || "".equals(str));
    }

}
