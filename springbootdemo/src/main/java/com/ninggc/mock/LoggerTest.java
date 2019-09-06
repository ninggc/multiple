package com.ninggc.mock;

import com.ninggc.common.util.LoggerUtil;
import org.junit.Test;

public class LoggerTest {

    static {
        String location = "classpath:log/log4j2.xml";
        System.setProperty("log4j.configurationFile", location);
    }

    LoggerUtil logger = new LoggerUtil(LoggerTest.class);

    @Test
    public void test1() {
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");

        for (int i = 0; i < 50000; i++) {
//            logger.error("error level " + i);
        }
    }
}
