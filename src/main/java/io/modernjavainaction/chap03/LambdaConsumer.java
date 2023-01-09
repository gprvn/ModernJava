package io.modernjavainaction.chap03;

import io.modernjavainaction.chap02.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaConsumer {
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

        //get only first name by calling forEach method
        forEach(students,s-> System.out.println(s.getFirstName()));

        //get only lastname by calling forEeach method
        forEach(students,s -> System.out.println(s.getLastName()));

        //get only scores by calling forEach method
        forEach(students, s -> System.out.println(s.getScore()));

    }
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T t : list){
            c.accept(t);
        }
    }
}
