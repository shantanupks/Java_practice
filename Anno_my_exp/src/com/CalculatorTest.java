package com;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
	
	Calculator calculator;
	
	@Before
	public void setUp(){
		System.out.println("@Before");
		calculator = new Calculator();
	}
	
	@Test
	public void add1() {
		int actual = calculator.add(20, 10);
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	@Test
	public void add2() {
		int actual = calculator.add(10, 30);
		int expected = -20;
		assertEquals(expected, actual);
	}

}
