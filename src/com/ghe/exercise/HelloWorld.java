package com.ghe.exercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
	private static final Logger logger = LogManager.getLogger("HelloWorld");
	public static void main(String[] args) {
        System.out.println("Hello World me");
        logger.info("Hello, World!");
    }
}