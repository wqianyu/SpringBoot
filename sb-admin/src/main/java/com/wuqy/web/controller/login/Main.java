package com.wuqy.web.controller.login;

import org.apache.commons.codec.binary.Base64;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
            System.out.println(Base64.encodeBase64String("testticketwuqy".getBytes()));
        System.out.println(new String(Base64.decodeBase64("dGVzdHRpY2tldHd1cXk=")));
        System.out.println(generateTicket());
        System.out.println(new String(Base64.decodeBase64(generateTicket())));
    }

    private static String generateTicket() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append(Thread.currentThread().getName());
        sb.append(new Random().nextInt(10000));
        return java.util.Base64.getEncoder().encodeToString(sb.toString().getBytes());
    }
}
