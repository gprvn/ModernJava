package io.modernjavainaction.chap03;

import io.modernjavainaction.chap02.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class LambdaFunction {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("Jane","Smith",25,62.5,15),
                new Student("John","Doe",21,67.15,11),
                new Student("Sarah","Thomas",22,69.3,12),
                new Student("Frank","Brown",25,75.9,15),
                new Student("Mike","Davis",22,89.0,12),
                new Student("Jennifer","Wilson",21,96.5,11),
                new Student("Jessica","Garcia",22,42.0,12),
                new Student("Fred","Clark",25,78.5,15),
                new Student("Bob","Lopez",21,55.5,11));

        List<Double> mapStudentScore = map(students, s -> s.getScore());
        System.out.println(mapStudentScore);

        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000); // TRUE -- boxing
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
        oddNumbers.test(1000); //false --no boxing

    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(f.apply(t));
        }
        return result;
    }
}
