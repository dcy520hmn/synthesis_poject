package com.springboot.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    @Pointcut("execution(public * com.springboot.service.impl.*.*(..))")
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


    @Around("dsPointCut()")
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
