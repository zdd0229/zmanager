package com.z.security.jwt;

import lombok.Data;

@Data
public class JwtTokenPair {
    private static final long serialVersionUID = -8518897818107784049L;
    private String accessToken;
    private String refreshToken;
}
