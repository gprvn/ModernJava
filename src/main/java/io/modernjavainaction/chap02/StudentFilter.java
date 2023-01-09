package io.modernjavainaction.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentFilter {
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

        List<Student> nameStartsFromJ = findNameStartsFromJ(students,'J');
        System.out.println(nameStartsFromJ);
        List<Student> studentsBasedOnGivenAge = findStudentsBasedOnGivenAge(students, 22);
        System.out.println(studentsBasedOnGivenAge);
        List<Student> nameStartsFromJ_new = findNameStartsFromJ_new(students, new FindNameStartsFromGivenChar());
        System.out.println("this is from the abstraction: \n"+nameStartsFromJ_new);

        //Using lambda
        List<Student> findNameStartWithJ = filterStudents(students, (Student student) -> 'J' == student.getFirstName().charAt(0));
        System.out.println("filter using lambda: \n"+findNameStartWithJ);

    }

    public static List<Student> filterStudents(List<Student> students, StudentPredicate p){
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(p.filterStudents(student))
                result.add(student);
        }
        return result;
    }

    private static List<Student> findNameStartsFromJ_new(List<Student> students, StudentPredicate p) {
        List<Student> result = new ArrayList<>();
//        for(Student student : students){
//            if(student.getFirstName().charAt(0) == j)
//                result.add(student);
//        }
//        return result;
        for(Student student : students){
            if(p.filterStudents(student)){
                result.add(student);
            }
        }
        return result;
    }

    private static List<Student> findNameStartsFromJ(List<Student> students, char j) {
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getFirstName().charAt(0) == j)
                result.add(student);
        }
        return result;
    }

    private static List<Student> findStudentsBasedOnGivenAge(List<Student> students, int age) {
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getAge() == age)
                result.add(student);
        }
        return result;
    }
}

class FindNameStartsFromGivenChar implements StudentPredicate {

    @Override
    public boolean filterStudents(Student student) {
        return student.getFirstName().charAt(0) == 'J';
    }
}

interface StudentPredicate {
    boolean filterStudents(Student student);
}



