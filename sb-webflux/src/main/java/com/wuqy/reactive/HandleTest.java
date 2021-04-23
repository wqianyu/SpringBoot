package com.wuqy.reactive;

public class HandleTest {

    public static void handle(Integer data) {
        System.out.println(data);
        if(3 == data) {
            data = data/(data-3);
        }
    }
}
