package com.laoyin.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年09月22日 10:47 上午
 */
public class TestLog {

    public static void main(String[] args) throws Exception {
//        ConfigurationSource source = new ConfigurationSource(new BufferedInputStream(new FileInputStream("/Users/gongyinquan/projects/maven_test/log4j2.xml")));
//        Configurator.initialize(null, source);
        Logger logger = LoggerFactory.getLogger("mylog");
//        Logger logger = LogManager.getLogger("mylog");
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");


    }
}
