package com.util;


public class Student {
    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String institution) {
        Institution = institution;
    }

    private String Institution;

    private String sex;

    @Override
    public String toString() {
        return "Student{" +
                "Institution='" + Institution + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
