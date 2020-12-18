package com.wuqy.service.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.Strings;
import com.wuqy.common.entity.content.JinhongAccount;
import org.joda.time.DateTime;

import java.util.UUID;

public class TokenUtils {

    public static void main(String[] args) {
        JinhongAccount user = JinhongAccount.builder().id(1).password("test1").build();
        String token = getToken(user);
        System.out.println(getToken(user));
        System.out.println(decodeToken(token));
//        verify(user, token);
        user = JinhongAccount.builder().id(2).password("test2").build();
        token = getToken(user);
        System.out.println(getToken(user));
        System.out.println(decodeToken(token));
        System.out.println(UUID.randomUUID().toString());
        System.out.println("==================");
        token = jwtToken("1001", "wuqy", "manager");
        System.out.println(token);
        decode(token);
        System.out.println("==================");
    }

    public static String getToken(JinhongAccount user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public static String decodeToken(String token) {
        return JWT.decode(token).getAudience().get(0);
    }

    public static void verify(JinhongAccount user, String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
    }

    private static String jwtSecret = "jwtSecret";

    private static String jwtToken(String userId, String username, String role) {
        return JWT.create()
                .withClaim("userId", userId)
                .withClaim("username", username)
                .withClaim("role", role)
                .withClaim("expireAt", new DateTime().plusMinutes(30).getMillis())
                .sign(Algorithm.HMAC256(jwtSecret));
    }

    private static void decode(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(jwtSecret)).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);
            String username = verify.getClaim("username").asString();
            String role = verify.getClaim("role").asString();
            Long expireAt = verify.getClaim("expireAt").asLong();
            //token参数不对
            if (!Strings.isNullOrEmpty(username)
                    && !Strings.isNullOrEmpty(role) && expireAt != null
                    && expireAt > System.currentTimeMillis()) {
                System.out.println(true);
            }

        } catch (JWTVerificationException ignore) {
            //验证失败
        }

    }
}
