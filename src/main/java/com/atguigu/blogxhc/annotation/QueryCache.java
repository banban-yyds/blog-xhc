package com.atguigu.blogxhc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryCache {
    public  String keyPrefix() default ""; // 设置注解可以传入一个String的值，用于给通知方法传key的前缀，实现通知方法的复用
}


