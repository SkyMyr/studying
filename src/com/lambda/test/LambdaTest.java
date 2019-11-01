package com.lambda.test;

import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import javax.swing.*;
/**
 * @ClassNameLambdaTest
 * @Description lambda表达式
 * @Author myr
 * @Date 2019/10/31 15:07
 * @Version 1.0
 **/
public class LambdaTest {

    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury","Venus","Earth","Mars"};
        System.out.println(Arrays.toString(planets));
        System.out.println();
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println();
        Arrays.sort(planets,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));
        Timer t = new Timer(1000, event ->
                System.out.println(new Date()));
        t.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
