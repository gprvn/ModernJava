package io.modernjavainaction.chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectApple {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(160,"RED"),new Apple(70,"GREEN"),new Apple(109,"GREEN"));
        List<Apple> redAndheavyApples = filterApples(apples, new AppleRedAndHeavyPredicate());
        System.out.println(redAndheavyApples);
    }

    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : apples){
            if(p.test(apple))
                result.add(apple);
        }
        return result;
    }
}
class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "RED".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}


