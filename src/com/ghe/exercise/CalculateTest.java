package com.ghe.exercise;

import org.junit.Before;  
import org.junit.Test;  
// 静态导入  
import static org.junit.Assert.*;  
  
public class CalculateTest {  
    private Calculate cal;  
      
    // 执行任意一个方法之前都会执行setUp方法  
    @Before  
    public void setUp(){  
        cal = new Calculate();  
    }  
      
    // 加了@Test表示该方法是一个单元测试  
    @Test  
    public void testAdd(){  
        /* 
         * 以下是一个简单的断言的编写 
         * 第一个参数是如果出错给出的提示信息 
         * 第二个表示期望值，通常是用户指定的内容 
         * 第三个表示代码返回的实际值 
         */  
    //  Assert.assertEquals("加法有问题", 34, cal.add(12,22));  
        /* 
         * 由于包进行了静态导入之后 
         * Assert中的所有静态方法就不用再添加类名了 
         * 这样可以有效地兼容junit3 
         */  
        assertEquals("加法有问题", 34, cal.add(12,22));  
    }  
    @Test  
    public void testMinus(){  
        int res = cal.minus(12, 2);  
 //     Assert.assertEquals("减法有问题", 10, res);  
        assertEquals("减法有问题", 10, res);  
    }  
    // 表示这个测试类应该抛出ArithmeticException,如果不抛出就报错  
    @Test(expected=ArithmeticException.class)  
    public void testDivide(){  
        int res = cal.divide(12, 0);  
        assertEquals("除法有问题", 6, res);  
    }  
      
    // 时间单位为ms  
    @Test(timeout=190)  
    public void testTime() throws InterruptedException{  
        Thread.sleep(209);  
        int rel = cal.divide(12, 2);  
    }  
      
    @Test  
    public void testMulti(){  
        int res = cal.multi(12, 2);  
        assertEquals("乘法有问题",24,res);  
    }  
    //hamcrest 1.3  
}  