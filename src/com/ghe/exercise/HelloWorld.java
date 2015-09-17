package com.ghe.exercise;

import org.apache.log4j.Logger;

public class HelloWorld {
	private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());
	public static void main(String[] args) {
//        BasicConfigurator.configure();
        logger.trace("Hello, World! said by trace");
        logger.debug("Hello, World! said by debug");
        logger.info("Hello, World! said by info");
        System.out.println("--java.ext.dirs=" + System.getProperty("java.ext.dirs"));
        System.out.println("Finished! Log file is in ${basedir}/log");
    }
}