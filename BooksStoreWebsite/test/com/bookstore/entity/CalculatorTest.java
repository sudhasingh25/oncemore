package com.bookstore.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator= new Calculator();
		int a=55;
		int b=22;
		int result=calculator.add(a, b);
		int expected=77;
		assertEquals(expected, result);
		
	}

}
