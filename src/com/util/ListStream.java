package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListStream {
    public static void main(String[] args) {
        List<Student> stuList=initStuList2();
        System.out.println(stuList);
        Map<String, List<Student>> collect = stuList.stream().collect(Collectors.groupingBy(Student::getInstitution));
        for(String key:collect.keySet()){
            System.out.println(key+":" +collect.get(key).size());
            System.out.println(collect.get(key));
        }
    }


    public static  List<Student> initStuList2(){
        List<Student> stuList=new ArrayList<>();
        for(int i=0;i<10;i++){
            Student student = new Student();
            String [] institution={"信息学院","文学院","音乐学院","体院","理学院","机电学院"};
            int ss=(int)(Math.random()*6);
            student.setInstitution(institution[ss]);
            String[] sexs={"男","女"};
            int ii=((int) Math.random());
            student.setSex(sexs[ii]);
            stuList.add(student);
        }
        return stuList;
    }
}
