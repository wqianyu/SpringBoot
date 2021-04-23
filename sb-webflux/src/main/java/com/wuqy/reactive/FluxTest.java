package com.wuqy.reactive;

import reactor.core.publisher.Flux;

public class FluxTest {

    public static void main(String[] args) throws Exception {
        Flux<Integer> ints3 = Flux.range(1, 4);
        ints3.subscribe(System.out::println);
        System.out.println("===========");

        ints3.subscribe(System.out::println,
                error -> System.err.println("Error " + error));
        System.out.println("===========");


        ints3.subscribe(System.out::println,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"));

        System.out.println("===========");
        ints3.subscribe(System.out::println,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(2));
        System.out.println("======================");

        try {
//            ints3.subscribe(HandleTest::handle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ints3.subscribe(HandleTest::handle,
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"));
        System.out.println("================================");

        ints3 = Flux.range(1, 2);
        ints3.subscribe(System.out::println);
    }
}
