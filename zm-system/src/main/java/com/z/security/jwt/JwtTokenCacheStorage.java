package com.z.security.jwt;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class JwtTokenCacheStorage implements JwtTokenStorage{

    private static final String TOKEN_CACHE = "usrTkn";

    @Override
    @CachePut(value = TOKEN_CACHE, key = "#userId")
    public JwtTokenPair put(JwtTokenPair jwtTokenPair, String userId) {
        return jwtTokenPair;
    }

    @Override
    @CacheEvict(value = TOKEN_CACHE, key = "#userId")
    public void expire(String userId) {

    }

    @Override
    @Cacheable(value = TOKEN_CACHE, key = "#userId")
    public JwtTokenPair get(String userId) {
        return null;
    }
}
