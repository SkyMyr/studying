package com.util;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args) {
        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        Date now = new Date();
        System.out.println("当前时间为：" + localDateTime);
        System.out.println("当前时间为：" + now);
        //获取当前月份
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        System.out.println("当前月份为：" + calendar.get(Calendar.MONTH));
        System.out.println("当前月份为：" + localDateTime.getMonthValue());
        //获取当前日期
        System.out.println("当前日期为：" + calendar.get(Calendar.DATE));
        System.out.println("当前日期为：" + localDateTime.getDayOfMonth());
        //只获取年月日
        System.out.println(new SimpleDateFormat("yy-MM-dd").format(now));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        format = format+"T00:00:00";
        System.out.println(LocalDateTime.parse(format));
        System.out.printf(format);
        System.out.printf(LocalDateTime.parse("2018-01-12T17:07:05").toString());



    }
}
