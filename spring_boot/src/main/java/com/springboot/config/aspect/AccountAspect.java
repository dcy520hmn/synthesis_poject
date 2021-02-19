package com.springboot.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * account 切面，在accountService进行转账的时候进行额外的操作。主要了解前置通知、后置通知、环绕通知。
 * 主要是队AOP知识进行学习，其中对
 * 测试代码在：com/springboot/AopTest.java
 * 同事对PointCut常见注解就行了验证
 */

@Aspect
@Component
public class AccountAspect {


    /**
     * execution形式
     */
    @Pointcut("execution(public * com.springboot.service.impl.AccountService.transfer(..))")
    private void dsPointCut()
    {

    }

    @Before("dsPointCut()")
    public void before(){
        System.out.println("设置非自动提交，开启事务");
    }

    @After("dsPointCut()")
    public void after(){
        System.out.println("提交");
    }

    @AfterReturning("dsPointCut()")
    public void afterReturn(){
        System.out.println("释放资源");
    }

    @AfterThrowing("dsPointCut()")
    public void afterThrow(){
        System.out.println("异常回滚");
    }


    /**
     * annotation:自定义注解标注在方法上的方法执行aop方法
     * within:自定义注解标注在的类上；该类的所有方法（不包含子类方法）执行aop方法
     */
    @Pointcut("@annotation(com.springboot.config.aspect.LogAspect)"+
            "||@within(com.springboot.config.aspect.LogAspect)")
    private void defineCut(){

    }

    @Before("defineCut()")
    public void logBefore(){
        System.out.println("before_log");
    }


    @After("defineCut()")
    public void logAfter(){
        System.out.println("after_log");
    }

    //@Around("dsPointCut()")
    public void around(ProceedingJoinPoint pjp){
        //获取方法执行所需的参数
        Object rtValue = null;
        try {
            //获取方法执行所需的参数
            Object[] args = pjp.getArgs();
            System.out.println("1");
            //执行方法
            rtValue = pjp.proceed(args);
            System.out.println("2");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
