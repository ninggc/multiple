package com.ninggc.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
    @Pointcut("execution(* com.ninggc.demo.aspect.*..*(..))")
    private void pointCutMethod() {
    }

//    @Before("pointCutMethod()")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("before");
//        Object[] args = joinPoint.getArgs();
//        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
//    }
//
//    @AfterReturning("pointCutMethod()")
//    public void afterReturning() {
//        System.out.println("return");
//    }
//
//    @AfterThrowing("pointCutMethod()")
//    public void afterThrowing() {
//        System.out.println("throw");
//    }

    @Around("pointCutMethod()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before");
        Object[] args = joinPoint.getArgs();
//        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Object proceed = joinPoint.proceed(args);

        System.out.println("after");
    }
}
