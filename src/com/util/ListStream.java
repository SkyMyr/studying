package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStream {
    public static void main(String[] args) {

        int x = 1;
        Integer y = 1;
        if(x==y)
            System.out.println("xxx");

        entrySet();
        List<Student> stuList=initStuList2();
        System.out.println(stuList);
        List<String> collect1 = stuList.stream()
                .map(Student::getInstitution)
                .distinct()
                .collect(Collectors.toList());

        long sum = stuList.stream()
                .map(Student::getInstitution)
                .distinct()
                .count();

        stuList.stream().mapToInt(Student::getAge).average()
        ;
        List<String> collect2 = collect1.stream()
                .distinct().collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(sum);
        System.out.println(stuList.stream().map(Student::getInstitution).collect(Collectors.toList()).stream().distinct());
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

    public static void entrySet(){
        List<Student> list = new ArrayList();
        list.add(new Student(10,"tom","man"));
        list.add(new Student(20,"salary","woman"));
        list.add(new Student(30,"john","man"));
        list.add(new Student(40,"john","man"));
        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getInstitution));
        System.out.println(map);
        List<Student> collect = map.entrySet().stream().map(item -> {
            Student info = new Student();
            info.setInstitution(item.getKey());
            info.setAge(item.getValue().stream().mapToInt(Student::getAge).sum());
            System.out.print(info.getInstitution());
            System.out.print(info.getAge());
            System.out.println(info);
            return info;
        }).collect(Collectors.toList());
        System.out.println(collect);

    }
}
