/* TigerTest works with build.xml, Animal.java, Tiger.java, to demo how to use junit.
 * 1) in build.xml, should specify <formatter type="xml"/> for generate junit report.
 * 2) use Assert.assertEquals(expected, actual) to assert result.
 * 3) report is generated in build/junitreport/index.html
 * 
 * Animal class, Tiger class also are used in Foo.java Bar.java for investgating 
 * "covariant(协变) return type"
 */
package com.ghe.exercise;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TigerTest {
	private static final Logger logger = Logger.getLogger(TigerTest.class);
	
	private Animal ani;
	private Tiger tig;

	@Before
	public void setUp() {
		ani = new Animal(33,37);
		tig = new Tiger(133,137,19);
	}
	
	@Test
	public void testToString() {
		System.out.println("ani:    " + ani);
		System.out.println("tig:    " + tig);
		logger.info("ani:" + ani);
		logger.info("tig:" + tig);
	}

	@Test
	public void testTypeChange() {
		Tiger t = (Tiger) new Animal();
		logger.info("t: " + t);
	}

	@Test
	public void testClone() {
		Animal a = new Animal(44,45);
    	Animal ac = a.clone();
    	Assert.assertEquals(44, ac.height);
    	Assert.assertEquals(45, ac.weight);

		Tiger t = new Tiger(54,55,13);
		Tiger tc = t.clone();
    	Assert.assertEquals(54, tc.height);
    	Assert.assertEquals(55, tc.weight);
    	Assert.assertEquals(13, tc.teeth);
	}

}
