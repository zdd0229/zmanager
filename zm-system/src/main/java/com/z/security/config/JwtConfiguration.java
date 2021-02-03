package com.z.security.config;

import com.z.security.jwt.JwtProperties;
import com.z.security.jwt.JwtTokenCacheStorage;
import com.z.security.jwt.JwtTokenGenerator;
import com.z.security.jwt.JwtTokenStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(JwtProperties.class)
@ConditionalOnProperty(prefix = "jwt.config",name = "enabled")
@Configuration
public class JwtConfiguration {

    /**
     * Jwt token storage .
     *
     * @return the jwt token storage
     */
    @Bean
    public JwtTokenStorage jwtTokenStorage() {
        return new JwtTokenCacheStorage();
    }


    /**
     * Jwt token generator.
     *
     * @param jwtTokenStorage the jwt token storage
     * @param jwtProperties   the jwt properties
     * @return the jwt token generator
     */
    @Bean
    public JwtTokenGenerator jwtTokenGenerator(JwtTokenStorage jwtTokenStorage, JwtProperties jwtProperties) {
        return new JwtTokenGenerator(jwtTokenStorage, jwtProperties);
    }

}
