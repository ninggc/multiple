package com.ninggc.config.impl;

import com.ninggc.config.AopConfiguration;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 控制controller的函数的入口和出口处打印日志
 */
@Component
public class ControllerAopConfigurationImpl implements AopConfiguration {

    @Override
    public void before(JoinPoint joinPoint) {
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Object[] args = joinPoint.getArgs();
        String classAndMethodName = joinPoint.getSignature().toShortString();

        String logContent = "before controller execute: " + classAndMethodName + "\t" +
                gson.toJson(parameterNames) + " --> " + gson.toJson(args);
        logger.info(logContent);
    }

    @Override
    public Object afterReturn(JoinPoint joinPoint, Object returnValue) {
        String classAndMethodName = joinPoint.getSignature().toShortString();

        String logContent = "after controller execute: " + classAndMethodName + "\t"
                + "result --> " + gson.toJson(getResultToAopResult(returnValue));
        logger.info(logContent);
        return returnValue;
    }

    @Override
    public void afterThrow(JoinPoint joinPoint, Exception exception) throws Exception {
        String classAndMethodName = joinPoint.getSignature().toShortString();
        String logContent = "after controller execute: " + classAndMethodName + "\t"
                + "throw --> " + gson.toJson(exception.getMessage());
        logger.info(logContent);
        throw exception;
    }

    @Override
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before");
        Object[] args = joinPoint.getArgs();
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();

        Object proceed = joinPoint.proceed(args);

        System.out.println("after");
    }
}
