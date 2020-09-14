package com.soprasteriaindia.rlg.WebCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soprasteriaindia.rlg.WebCalculator.service.WebCalculatorService;

@SpringBootTest
class WebCalculatorFunctionsulatorApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Autowired
	private WebCalculatorService cser;

	@Test
	@DisplayName("Test cases for validateNum function in service testcase01")
	public void testcase01() {
		System.out.println("validateNum(12)"+"true");
		assertEquals(cser.validateNum("12"),true);

		System.out.println("validateNum(12asd)"+"true");
		assertEquals(cser.validateNum("12asd"),false);
		
		System.out.println("validateNum(12.0)"+"true");
		assertEquals(cser.validateNum("12.0"),true);

		System.out.println("validateNum(-12.0)"+"true");
		assertEquals(cser.validateNum("-12.0"),true);

		System.out.println("validateOper('+')"+true);
		assertEquals(cser.validateOper('+'),true);

		System.out.println("validateOper('-')"+true);
		assertEquals(cser.validateOper('-'),true);

		System.out.println("validateOper('*')"+true);
		assertEquals(cser.validateOper('*'),true);

		System.out.println("validateOper('/')"+true);
		assertEquals(cser.validateOper('/'),true);

		System.out.println("validateOper('%')"+false);
		assertEquals(cser.validateOper('%'),false);

		//		assertEquals(cser.validateNum("12asd"),true);
	}

	@Test
	@DisplayName("Test cases for calculatorFunctions function in service testcase02")
	public void testcase02() {
		System.out.println("calculatorFunctions(12+123)"+cser.calculatorFunctions("12","123",'+'));
		assertEquals(cser.calculatorFunctions("12","123",'+'),"135.0");

		System.out.println("calculatorFunctions(12-123)"+cser.calculatorFunctions("12","123",'-'));
		assertEquals(cser.calculatorFunctions("12","123",'-'),"-111.0");

		System.out.println("calculatorFunctions(123-12)"+cser.calculatorFunctions("123","12",'-'));
		assertEquals(cser.calculatorFunctions("123","12",'-'),"111.0");

		System.out.println("calculatorFunctions(123-123)"+cser.calculatorFunctions("123","123",'-'));
		assertEquals(cser.calculatorFunctions("123","123",'-'),"0.0");

		System.out.println("calculatorFunctions(12*123)"+cser.calculatorFunctions("12","123",'*'));
		assertEquals(cser.calculatorFunctions("12","123",'*'),"1476.0");

		System.out.println("calculatorFunctions(120*30)"+cser.calculatorFunctions("120","30",'*'));
		assertEquals(cser.calculatorFunctions("120","30",'*'),"3600.0");

		System.out.println("CalculatorFunctions(121/12)"+cser.calculatorFunctions("121","11",'/'));
		assertEquals(cser.calculatorFunctions("121","11",'/'),"11.0");

		System.out.println("CalculatorFunctions(12/123)"+cser.calculatorFunctions("12","123",'/'));
		assertEquals(cser.calculatorFunctions("12","123",'/'),"0.0975609756097561");

		System.out.println("CalculatorFunctions(12^2)"+cser.calculatorFunctions("12","2",'^'));
		assertEquals(cser.calculatorFunctions("12","2",'^'),"0.0");

	}
}
