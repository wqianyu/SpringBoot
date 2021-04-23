package com.wuqy.reactive;

import reactor.core.publisher.Mono;

import java.util.Date;

public class MonoDeferTest {
    public static void main(String[] args) {
        //声明阶段创建DeferClass对象

        Mono<Date> m1 = Mono.just(new Date());
        Mono<Date> m2 = Mono.defer(()->Mono.just(new Date()));
        m1.subscribe(System.out::println);
        m2.subscribe(System.out::println);
        //延迟5秒钟
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m1.subscribe(System.out::println);
        m2.subscribe(System.out::println);
    }
}
