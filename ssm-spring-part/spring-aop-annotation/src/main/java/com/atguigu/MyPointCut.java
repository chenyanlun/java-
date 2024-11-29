package com.atguigu;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//存储切点的类
@Component
public class MyPointCut {
    //切点表达式的提取和复用
    @Pointcut("execution(* com.atguigu.service.impl.*.*(..))")
    public void pc(){}

    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc(){}
}
