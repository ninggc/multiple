package com.ninggc.util.morphia.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 日志的简单包装
 */
public class LoggerUtil {
    Logger logger = null;
    Class clazz;

    /**
     * @param clazz
     */
    public LoggerUtil(Class<?> clazz) {
        logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        this.clazz = clazz;
    }

    /**
     * @return 如果配置文件不存在，则返回null
     */
//    public static Logger getLogger(Class<?> clazz) {
//        Logger logger = null;
//        logger = LogManager.getLogger(clazz);
//        return logger;
//    }

    public void debug(String msg) {
        logger.debug("------" + msg + "------");
    }

    public void info(String msg) {
        logger.info(msg);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }

    public void error(String msg) {
        logger.error(msg);
    }

    public void fatal(String msg) {
        logger.fatal(msg);
    }

    public void startService(String msg) {
        logger.error(clazz.getSimpleName() + " mongodb 开始:  " + msg);
    }
    public void endService(String msg) {
        logger.error(clazz.getSimpleName() + " mongodb 结束:  " + msg);
    }

    public void startMysqlService(String msg) {
        logger.error(clazz.getSimpleName() + " mysql 开始:  " + msg);
    }

    public void endMysqlService(String msg) {
        logger.error(clazz.getSimpleName() + " mysql 结束:  " + msg);
    }

    public void startHttpClient(String msg) {
        logger.error(clazz.getSimpleName() + " http 开始:  " + msg);
    }

    public void endHttpClient(String msg) {
        logger.error(clazz.getSimpleName() + " http 结束:  " + msg);
    }
}
