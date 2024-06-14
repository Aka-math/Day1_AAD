package com.example.vitbatch2.javaexs;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator calculator;

    //oncreate
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator();
    }

    public void testAdd() {
        int expected = 35;
        int actual = calculator.add(10,20);
        assertEquals(expected,actual);
    }

    //ondestroy

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMultiply() {
        int expected = 20;
        int actual = calculator.multiply(5,4);
        assertEquals(expected,actual);
    }
}