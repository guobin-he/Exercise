package com.ghe.exercise;

import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class HelloWorldTest extends TestCase {
    public void testNothing() {
    	assertThat("HelloWorld", startsWith("Hello"));
    	assertThat("text", startsWith("textHello"));
    }
    
    public void testWillAlwaysFail() {
        fail("An error message");
    }
}
