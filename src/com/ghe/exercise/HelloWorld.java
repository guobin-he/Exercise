/* This class is created following the content on
 * https://ant.apache.org/manual/tutorial-HelloWorldWithAnt.html
 * The following topic are exercised:
 * 1) create a Java Class "HelloWorld"
 * 2) create a build.xml to build the project
 * 3) Add log4j v1.2 for logging to stdout and a common log file
 * 4) Add junit v4.12 and hamcrest v1.3 for unit testing
 */

package com.ghe.exercise;

import org.apache.log4j.Logger;

import junit.runner.Version;

public class HelloWorld {
	private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());
	public static void main(String[] args) {
//        BasicConfigurator.configure();
        logger.trace("Hello, World! said by trace");
        logger.debug("Hello, World! said by debug");
        logger.info("Hello, World! said by info");
        System.out.println("--java.ext.dirs=" + System.getProperty("java.ext.dirs"));
        System.out.println("Finished! Log file is in ${basedir}/log");

        System.out.println("How to check Junit version? JUnit version is: " + Version.id());
	}
}