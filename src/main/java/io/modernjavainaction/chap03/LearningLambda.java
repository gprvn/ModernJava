package io.modernjavainaction.chap03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import io.modernjavainaction.chap03.Apple;

public class LearningLambda {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "GREEN"),
                new Apple(155, "RED"),
                new Apple(151, "GREEN"),
                new Apple(120, "RED"));

        //List green apples
        List<Apple> greenApples = filterApples(inventory, apple -> "GREEN".equalsIgnoreCase(apple.getColor()));
        System.out.println(greenApples);

        // implementing run method using Lambda
        Runnable r1 = () -> System.out.println("from runnable r1, using lambda");

        // implementing run method using Anonymous class implementation
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("from runnable r2, anonymous class");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();

        Thread t3 = new Thread(()-> System.out.println("from lambda runnable as function"));
        t3.start();
//        filter(inventory, (String s) -> !s.isEmpty())
    }

//    private static <T> void filter(List<Apple> inventory, Predicate<T> tPredicate) {
//    }

    public String processFile() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("Understanding.txt"));
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicateInterface p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    //  Predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(p.test(t))
                result.add(t);
        }
        return result;
    }
}




interface ApplePredicateInterface {
    boolean test(Apple apple);
}
