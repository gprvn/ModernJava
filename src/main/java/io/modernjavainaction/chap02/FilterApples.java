package io.modernjavainaction.chap02;

import io.modernjavainaction.chap02.Apple;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApples {

    public static void main(String[] args) {
        List<io.modernjavainaction.chap02.Apple> inventory = Arrays.asList(new Apple(80, "GREEN"), new Apple(155, "RED"), new Apple(120, "RED"));
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println("Green Apple Collection: "+greenApples);
        List<Apple> redColorApple = filterApplesByColor(inventory, Color.RED);
        System.out.println("Red Color Apple Collection: "+redColorApple);
        List<Apple> greenColorApple = filterApplesByColor(inventory, Color.GREEN);
        System.out.println("Green Color Apple Collection: "+greenColorApple);
        List<Apple> weightedApples = filterAppleByWeight(inventory,150);
        System.out.println("Weighted apples are: "+weightedApples);

//        filtering by abstract criteria
        List<Apple> redAndHeavy = filterApples(inventory, new AppleRedAndHeavyPredicate());
        System.out.println("red and heavy apples: "+redAndHeavy);

//        pretty print apple
        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }

    /**
     *
     * @param inventory
     * @param weight
     * @return
     */
    private static List<Apple> filterAppleByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getWeight() > weight)
                result.add(apple);
        }
        return result;
    }

    /**
     * filter apples based on
     * @param inventory
     * @return
     */
    private static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(color.toString().equals(apple.getColor()))
                result.add(apple);
        }
        return result;
    }


    /**
     * filter green apples
     * @param inventory
     * @return
     */
    private static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> greenApples = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor().equalsIgnoreCase(Color.GREEN.toString()))
                greenApples.add(apple);
        }
        return greenApples;
    }

//    filtering by abstract criteria
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, ApplePrettyPrintPredicate format){
        System.out.println("Pretty Print Apple is executing..");
        for(Apple apple : inventory){
            System.out.println(format.format(apple));
        }
    }

}
class AppleRedAndHeavyPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return Color.RED.toString().equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150;
    }
}

class AppleFancyFormatter implements ApplePrettyPrintPredicate {

    @Override
    public String format(Apple apple) {
        String name = apple.getWeight() > 150 ? "heavy":"light";
        return "A "+name+" "+apple.getColor()+" apple";
    }
}

class AppleSimpleFormatter implements ApplePrettyPrintPredicate {

    @Override
    public String format(Apple apple) {
        return "An apple of "+apple.getWeight()+" gm";
    }
}
interface ApplePrettyPrintPredicate {
    String format(Apple apple);
}

interface ApplePredicate {
    boolean test(Apple apple);
}
enum Color {RED, GREEN}

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