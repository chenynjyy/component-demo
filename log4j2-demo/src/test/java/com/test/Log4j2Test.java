package com.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {
    static public Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
//    static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log4j2Test.class);

    @Test
    public void logTC1(){
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.error("error {}", "param");
    }

}
