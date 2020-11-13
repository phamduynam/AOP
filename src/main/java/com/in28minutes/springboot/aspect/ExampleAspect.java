package com.in28minutes.springboot.aspect;

import com.in28minutes.springboot.model.Customer;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Aspect
@Component
public class ExampleAspect {

    @Pointcut("execution(* com.in28minutes.springboot.service.CustomerService.*(..)) && args(customer,id,..)")
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



    @Pointcut("execution(* com.in28minutes.springboot.service.CustomerService.*(..)) && args(id,..)")
    public void poincutMethodChangeInput(int id){

    }


    @Before("poincutMethodChangeInput(id)")
    public void changeData(int id){

    }


}
