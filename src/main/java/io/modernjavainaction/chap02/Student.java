package io.modernjavainaction.chap02;

public class Student {
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
                ", \nage=" + age +
                ", score=" + score +
                ", \nstandard=" + standard +
                '}';
    }
}
