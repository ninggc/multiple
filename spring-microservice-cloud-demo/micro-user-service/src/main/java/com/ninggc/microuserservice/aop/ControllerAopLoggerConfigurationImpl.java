package com.ninggc.microuserservice.aop;

import com.ninggc.util.common.config.aop.AopConfiguration;
import com.ninggc.util.common.config.aop.adapter.IAopAdapter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 控制controller的函数的入口和出口处打印日志
 */
@Component
@Aspect
public class ControllerAopLoggerConfigurationImpl extends AopConfiguration {
    public ControllerAopLoggerConfigurationImpl(IAopAdapter aopLogAdapter) {
        super(aopLogAdapter);
    }

    @Pointcut("execution(* com.ninggc.microuserservice.web.*..*(..))")
    @Override
    protected void pointCutMethod() {
    }

    @Override
    public String getTag() {
        return "controller";
    }
}
