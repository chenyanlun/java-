package com.atguigu.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**前置 @Before
 * 后置 @AfterReturning
 * 异常 @AfterThrowing
 * 最后 @After
 * 环绕 @Around
 *
 * try{
 *     前置
 *     目标方法
 *     后置
 * }catch(){
 *     异常
 * }finally{
 *     最后
 * }
 *
 * 配置切点表达式（选中插入的方法）*/

@Component //加入IOC容器
@Aspect //配置切面
public class LogAdvice {


    @Before("com.atguigu.MyPointCut.pc()")//("execution(* com.atguigu.service.impl.*.*(..))")
    public void start(){
        System.out.println("方法开始了");
    }

    @After("execution(* com.atguigu.service.impl.*.*(..))")
    public void after(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.atguigu.service.impl.*.*(..))")
    public void error(){
        System.out.println("方法报错了");
    }
}
