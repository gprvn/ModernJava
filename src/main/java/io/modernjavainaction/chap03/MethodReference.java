package io.modernjavainaction.chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

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

    }
}
