package com.ninggc.config;

import com.google.gson.Gson;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 控制切面的自定义操作
 */
public interface AopConfiguration {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    Gson gson = new Gson();

    @Data
    class AopResult {
        private String explain;
        private String type;
        private Integer totalSize;
        private Integer totalLength;
        private List<Object> subList;
    }

    void before(JoinPoint joinPoint);

    /**
     * @param joinPoint
     * @param returnValue 返回值
     * @return
     */
    Object afterReturn(JoinPoint joinPoint, Object returnValue);

    /**
     * @param joinPoint
     * @param exception 抛出的异常
     * @throws Exception 处理之后要再次抛出
     */
    void afterThrow(JoinPoint joinPoint, Exception exception) throws Exception;

    /**
     * 暂时不用
     *
     * @param joinPoint
     * @throws Throwable
     */
    void around(ProceedingJoinPoint joinPoint) throws Throwable;

    /**
     * 如果结果是非常长的list，就要截取一部分打印到日志
     *
     * @param resultValue
     * @return
     */
    @SuppressWarnings("unchecked")
    default Object getResultToAopResult(final Object resultValue) {
//        如果结果太长默认只取三条
        final int maxSize = 3;
        final int maxLength = 300;
        AopResult aopResult = new AopResult();
        if (resultValue instanceof Collection) {
            Collection<Object> collection = (Collection<Object>) resultValue;
            int length = gson.toJson(collection).length();
            if (collection.size() > maxSize && length > maxLength) {
//                如果结果的长度大于maxSize，并且字符串长度大于maxLength
//                就取出其中的maxSize条数据打印在日志
                aopResult.setType(resultValue.getClass().getSimpleName());
                aopResult.setExplain("截取" + maxSize + "条结果展示！");
                aopResult.setTotalSize(collection.size());
                aopResult.setTotalLength(length);
                aopResult.setSubList(Arrays.asList(collection.toArray()).subList(0, maxSize));
                return aopResult;
            }
        }
        return (Object) resultValue;
    }
}
