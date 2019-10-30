package com.auto.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassNameAutoAnnotation
 * @Description 自定义注解
 * @Author myr
 * @Date 2019/10/30 11:02
 * @Version 1.0
 **/
public class AutoAnnotation {

    /**
     * 类注解
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ClassAnnotation{
        String value();
    }

    /**
     * 构造方法注解
     */
    @Target(ElementType.CONSTRUCTOR)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ConstructorAnnotation{
        String value();
    }

    /**
     * 普通方法注解
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MethodAnnotation{
        String value();
    }

    /**
     * 域注解
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldAnnotation{
        String value();
    }

    /**
     * 可以同时应用到类和方法上
     */
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ClassAndMethodAnnotation{
        String value() default "blue";
        // 定义枚举
        public enum EnumType {
            util, entity, service, model
        }

        // 设置默认值
        public EnumType classType() default EnumType.util;

        // 数组
        int[] arr() default { 3, 7, 5 };

    }
}
