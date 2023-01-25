package io.modernjavainaction.chap03;

import io.modernjavainaction.chap02.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaPredicate {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(151, Color.GREEN),
                new Apple(120, Color.RED));

        List<Student> students = Arrays.asList(new Student("Jane","Smith",25,62.5,15),
                new Student("John","Doe",21,67.15,11),
                new Student("Sarah","Thomas",22,69.3,12),
                new Student("Frank","Brown",25,75.9,15),
                new Student("Mike","Davis",22,89.0,12),
                new Student("Jennifer","Wilson",21,96.5,11),
                new Student("Jessica","Garcia",22,42.0,12),
                new Student("Fred","Clark",25,78.5,15),
                new Student("Bob","Lopez",21,55.5,11));

        List<Apple> greenApples = filter(inventory, (l) -> l.getColor().equals(Color.GREEN));
        System.out.println(greenApples);

        List<Apple> redApples = filter(inventory, apple -> apple.getColor().equals(Color.RED));
        System.out.println(redApples);

        List<Student> filterStudentsByAge = filter(students, student -> student.getAge() > 24);
        System.out.println(filterStudentsByAge);
        List<Student> filterByScore = filter(students, student -> student.getScore() > 80);
        System.out.println(filterByScore);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                results.add(t);
            }
        }
        return results;
    }
}
