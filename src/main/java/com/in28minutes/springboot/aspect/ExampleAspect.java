package com.in28minutes.springboot.aspect;

import com.in28minutes.springboot.model.Customer;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Aspect
@Component
public class ExampleAspect {

    @Pointcut("execution(* com.in28minutes.springboot.service.CustomerService.*(..))")
    public void poincutMethod(){

    }

    @Before("poincutMethod()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Tham so dau vao phuong thuc " + joinPoint.getSignature().getName() + " la :" + Arrays.toString( joinPoint.getArgs()));


    }


    @AfterReturning(pointcut = "poincutMethod()",returning = "returnData")
    public void afterRuningAdvice(JoinPoint joinPoint,Object returnData){
        System.out.println("Tham so dau ra phuong thuc " + joinPoint.getSignature().getName() + " la :" +  returnData.toString());
    }




    @Around("execution(* com.in28minutes.springboot.service.CustomerService.getCustomerById(..))")
    public Object changeData(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Tham so truyen vao la :" + Arrays.toString(proceedingJoinPoint.getArgs()));
        Object[] args =  proceedingJoinPoint.getArgs();
        // change value
        args[0] = (int)args[0] + 1;
        System.out.println("Tham so sau khi thay doi la :" + args[0]);
        return proceedingJoinPoint.proceed(args);
    }


}
