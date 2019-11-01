package com.auto.annotation;

import java.lang.reflect.Method;
import com.auto.annotation.AutoAnnotation;
/**
 * @ClassNameTestAnnotation
 * @Description 注解测试
 * @Author myr
 * @Date 2019/10/30 11:16
 * @Version 1.0
 **/
public class TestAnnotation  implements Cloneable{
    @AutoAnnotation.FieldAnnotation("域属性")
    private String myName;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @AutoAnnotation.ConstructorAnnotation("构造方法")
    public TestAnnotation(String myName) {
        this.myName = myName;
    }

    @AutoAnnotation.MethodAnnotation("Get方法")
    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public static void main(String[] args) {
        Class c = TestAnnotation.class;
        Method method = null;
        try {
            method = c.getMethod("getMyName");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        AutoAnnotation.MethodAnnotation methodAnnotation = method.getAnnotation(AutoAnnotation.MethodAnnotation.class);
        System.out.println(methodAnnotation.value());
    }
}
