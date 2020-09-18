package com.soprasteria.webcalculator.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 
 * This is the test class for the service class.
 * 
 * @author soprasteria
 *
 */
@SpringBootTest
class WebCalculatorServiceTest {
	@Autowired
	private WebCalculatorService csertest;

	@Test
	@DisplayName("Test cases for validateNum function in service")
	void validateNumTest() {
		assertEquals(true,csertest.validateNum("12"));
		assertEquals(false,csertest.validateNum("12asd"));
		assertEquals(true,csertest.validateNum("12.0"));
		assertEquals(true,csertest.validateNum("-12.0"));
	}
	
	@Test
	@DisplayName("Test cases for validateOper function in service")
	void validateOperTest() {
		assertEquals(true,csertest.validateOper('+'));
		assertEquals(true,csertest.validateOper('-'));
		assertEquals(true,csertest.validateOper('*'));
		assertEquals(true,csertest.validateOper('/'));
		assertEquals(false,csertest.validateOper('%'));
	}

	@Test
	@DisplayName("Test cases for calculatorFunctions function in service")
	void calculatorFunctionsTest() {
		assertEquals("135.0",csertest.calculatorFunctions("12","123",'+'));
		assertEquals("-111.0",csertest.calculatorFunctions("12","123",'-'));
		assertEquals("111.0",csertest.calculatorFunctions("123","12",'-'));
		assertEquals("0.0",csertest.calculatorFunctions("123","123",'-'));
		assertEquals("1476.0",csertest.calculatorFunctions("12","123",'*'));
		assertEquals("3600.0",csertest.calculatorFunctions("120","30",'*'));
		assertEquals("11.0",csertest.calculatorFunctions("121","11",'/'));
		assertEquals("0.0975609756097561",csertest.calculatorFunctions("12","123",'/'));
		assertEquals("0.0",csertest.calculatorFunctions("12","2",'^'));
	}
}
