package com.wuqy.spi;

public class Dog implements Animal {
    @Override
    public void handle() {
        System.out.println("dog");
    }
}
