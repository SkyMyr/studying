package com.util;

public class Student {

    private int age;

    private String Institution;

    private String sex;

    public Student(int age, String institution, String sex) {
        this.age = age;
        Institution = institution;
        this.sex = sex;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", Institution='" + Institution + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
