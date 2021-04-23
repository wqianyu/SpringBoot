package com.wuqy.spi;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
        for(Animal animal : load) {
            System.out.println(animal);
            animal.handle();
        }

//        ServiceLoader<Animal> load2 = ServiceLoader.load(Animal.class);
        for(Animal animal : load) {
            System.out.println(animal);
            animal.handle();
        }
    }
}
