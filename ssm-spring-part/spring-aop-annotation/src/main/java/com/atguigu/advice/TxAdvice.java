package com.atguigu.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10) //指定优先级，值越小越优先
public class TxAdvice {

    @Before("com.atguigu.MyPointCut.pc()")
    public void begin(){
        System.out.println("开启事务");
    }

    @AfterReturning("com.atguigu.MyPointCut.pc()")
    public void commit(){
        System.out.println("事务提交");
    }

    @AfterThrowing("com.atguigu.MyPointCut.pc()")
    public void rollback(){
        System.out.println("事务回滚");
    }
}
