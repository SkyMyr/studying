package com.myr.tree;

/**
 * @ClassNameStudent
 * @Description TODO
 * @Author myr
 * @Date 2019/9/22 16:55
 * @Version 1.0
 **/
public class Student {

    private String stuName;    // 学生姓名
    private String stuNum;     // 学号
    private String stuInfo;    // 学生信息

    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuNum() {
        return stuNum;
    }
    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }
    public String getStuInfo() {
        return stuInfo;
    }
    public void setStuInfo(String stuInfo) {
        this.stuInfo = stuInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum=" + stuNum +
                ", name='" + stuName + '\'' +
                ", otherInfo='" + stuInfo + '\'' +
                '}';
    }

}
