package com.z.security.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ConditionalOnClass(WebSecurityConfigurerAdapter.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class CustomWebSecurityConfiguration {

    @Configuration
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    static class DefaultConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            super.configure(auth);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            super.configure(web);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .cors()
                    .and()
                    .authorizeRequests().anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/process")
                    .successForwardUrl("/login/success").
                    failureForwardUrl("/login/failure");
        }
    }

}
