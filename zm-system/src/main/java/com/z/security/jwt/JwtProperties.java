package com.z.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "jwt.config")
public class JwtProperties {
    /**
     * 是否可用
     */
    private boolean enabled;
    /**
     * jks 路径
     */
    private String keyLocation;
    /**
     * key alias
     */
    private String keyAlias;
    /**
     * key store pass
     */
    private String keyPass;
    /**
     * jwt签发者
     **/
    private String iss;
    /**
     * jwt所面向的用户
     **/
    private String sub;
    /**
     * access jwt token 有效天数
     */
    private int accessExpDays;
    /**
     * refresh jwt token 有效天数
     */
    private int refreshExpDays;
}
