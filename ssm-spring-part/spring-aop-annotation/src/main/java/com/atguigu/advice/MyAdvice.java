package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Component
@Aspect
public class MyAdvice {

    @Before("com.atguigu.MyPointCut.myPc()")
    public void before(JoinPoint joinPoint){
        //获取方法属于类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        //获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();//修饰符
        String s = Modifier.toString(modifiers);
        String name = joinPoint.getSignature().getName();
        //获取参数列表
        Object[] args = joinPoint.getArgs();
    }

    @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){ //result接受返回结果

    }

    @After("execution(* com..impl.*.*(..))")
    public void after(JoinPoint joinPoint){

    }

    @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "throwable")
    public void error(JoinPoint joinPoint,Throwable throwable){

    }
}
