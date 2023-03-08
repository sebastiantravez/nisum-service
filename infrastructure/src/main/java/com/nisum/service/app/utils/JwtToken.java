package com.nisum.service.app.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nisum.service.app.dto.UserDto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtToken {
    public static String addToken(UserDto userDto) {
        String sign = "4^:s]6E5VMA3{ozdY@*";
        long EXPIRATION_DATE = 28_800_000;
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("user", userDto);
        return JWT.create()
                .withSubject(userDto.getName())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .sign(Algorithm.HMAC256(sign));
    }
}
