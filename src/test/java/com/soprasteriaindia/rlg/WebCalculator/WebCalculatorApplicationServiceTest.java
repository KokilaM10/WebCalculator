package com.soprasteriaindia.rlg.WebCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soprasteriaindia.rlg.WebCalculator.service.WebCalculatorService;

@SpringBootTest
class WebCalculatorApplicationServiceTest {
	@Autowired
	private WebCalculatorService csertest;

	@Test
	@DisplayName("Test cases for validateNum function in service")
	void validateNumTest() {
		System.out.println("validateNum(12)"+"true");
		assertEquals(true,csertest.validateNum("12"));

		System.out.println("validateNum(12asd)"+"true");
		assertEquals(false,csertest.validateNum("12asd"));
		
		System.out.println("validateNum(12.0)"+"true");
		assertEquals(true,csertest.validateNum("12.0"));

		System.out.println("validateNum(-12.0)"+"true");
		assertEquals(true,csertest.validateNum("-12.0"));
	}
	
	@Test
	@DisplayName("Test cases for validateOper function in service")
	void validateOperTest() {
		System.out.println("validateOper('+')"+true);
		assertEquals(true,csertest.validateOper('+'));

		System.out.println("validateOper('-')"+true);
		assertEquals(true,csertest.validateOper('-'));

		System.out.println("validateOper('*')"+true);
		assertEquals(true,csertest.validateOper('*'));

		System.out.println("validateOper('/')"+true);
		assertEquals(true,csertest.validateOper('/'));

		System.out.println("validateOper('%')"+false);
		assertEquals(false,csertest.validateOper('%'));
	}

	@Test
	@DisplayName("Test cases for calculatorFunctions function in service")
	void calculatorFunctionsTest() {
		System.out.println("calculatorFunctions(12+123)"+"135.0");
		assertEquals("135.0",csertest.calculatorFunctions("12","123",'+'));

		System.out.println("calculatorFunctions(12-123)"+"-111.0");
		assertEquals("-111.0",csertest.calculatorFunctions("12","123",'-'));

		System.out.println("calculatorFunctions(123-12)"+"111.0");
		assertEquals("111.0",csertest.calculatorFunctions("123","12",'-'));

		System.out.println("calculatorFunctions(123-123)"+"0.0");
		assertEquals("0.0",csertest.calculatorFunctions("123","123",'-'),);

		System.out.println("calculatorFunctions(12*123)"+"1476.0");
		assertEquals("1476.0",csertest.calculatorFunctions("12","123",'*'));

		System.out.println("calculatorFunctions(120*30)"+"3600.0");
		assertEquals("3600.0",csertest.calculatorFunctions("120","30",'*'));

		System.out.println("CalculatorFunctions(121/12)"+"11.0");
		assertEquals("11.0",csertest.calculatorFunctions("121","11",'/'));

		System.out.println("CalculatorFunctions(12/123)"+"0.0975609756097561");
		assertEquals("0.0975609756097561",csertest.calculatorFunctions("12","123",'/'));

		System.out.println("CalculatorFunctions(12^2)"+"0.0");
		assertEquals("0.0",csertest.calculatorFunctions("12","2",'^'));
	}
}
