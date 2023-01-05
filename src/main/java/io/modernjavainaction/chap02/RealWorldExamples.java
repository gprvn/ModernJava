package io.modernjavainaction.chap02;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class RealWorldExamples {

    public static void main(String[] args) {
        //Sorting with Comparator
        List<Student> students = Arrays.asList(new Student("Jane","Smith",25,62.5,15),
                new Student("John","Doe",21,67.15,11),
                new Student("Sarah","Thomas",22,69.3,12),
                new Student("Frank","Brown",25,75.9,15),
                new Student("Mike","Davis",22,89.0,12),
                new Student("Jennifer","Wilson",21,96.5,11),
                new Student("Jessica","Garcia",22,42.0,12),
                new Student("Fred","Clark",25,78.5,15),
                new Student("Bob","Lopez",21,55.5,11));

        System.out.println("non-sorted Student Collection: \n"+students);

        //ad-hoc implementation of Comparator
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });
        System.out.println("\n\nsorted Student Collection: \n"+students);

        //using lambda
        students.sort(
                (Student s1, Student s2) -> s2.getScore().compareTo(s1.getScore())
        );
        System.out.println("Sorted By Lambda: \n"+students);

        //executing block of code with Runnable
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Runnable.");
            }
        });
        t.start();

        Thread t2 = new Thread(() -> System.out.println("this is from Lambda Runnable."));
        t2.start();
    }
}

