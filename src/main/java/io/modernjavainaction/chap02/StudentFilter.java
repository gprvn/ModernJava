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
    }

    private static List<Student> findNameStartsFromJ(List<Student> students, char j) {
        List<Student> result = new ArrayList<>();
        for(Student student : students){
            if(student.getFirstName().charAt(0) == j)
                result.add(student);
        }
        return result;
    }
}

interface SelectStudents {
    boolean filterStudents(Student student);
}

class Student {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double score;
    private Integer standard;

    public Student(String firstName, String lastName, Integer age, Double score, Integer standard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.score = score;
        this.standard = standard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", standard=" + standard +
                '}';
    }
}

