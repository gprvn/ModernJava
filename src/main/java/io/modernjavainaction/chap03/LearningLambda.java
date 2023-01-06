package io.modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}

interface ApplePredicateInterface {
    boolean test(Apple apple);
}

class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
