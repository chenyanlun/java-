package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {

    @Around("com.atguigu.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("开启事务");
            result = joinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            e.printStackTrace();
        }finally {

        }
        return result;
    }
}
