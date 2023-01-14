package io.modernjavainaction.chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class MethodReference {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "GREEN"),
                new Apple(155, "RED"),
                new Apple(151, "GREEN"),
                new Apple(120, "RED"));

        ToIntFunction<String> stringToInt = Integer::parseInt;
        BiPredicate<List<String>, String> contains = List::contains;
//        Predicate<String> startWithNumber = this::startWithNumber;

        //constructor reference
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
        
        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c2.get();

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(150,"GREEN");
        System.out.println(c3);

        TriFunction<Integer, String, Integer, Apple> factory = Apple::new;
        Apple a4 = factory.apple(150,"GREEN",1);
    }
}
