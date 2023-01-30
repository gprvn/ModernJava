package io.modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)));

        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        //resuffling objects
        inventory.set(1, new Apple(30, Color.RED));
        System.out.println(inventory);
        inventory.sort((a1,a2) -> a1.getWeight() - a2.getWeight());
        System.out.println(inventory);
    }

    //this is for the implementation of the sort with the method reference and the lambda expression


}

class AppleComparator implements Comparator<Apple>{

    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight() - a2.getWeight();
    }
}