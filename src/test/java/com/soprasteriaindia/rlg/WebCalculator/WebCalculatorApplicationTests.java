package com.soprasteriaindia.rlg.WebCalculator;

//import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.soprasteriaindia.rlg.WebCalculator.controller.WebCalculatorController;
import com.soprasteriaindia.rlg.WebCalculator.service.WebCalculatorService;

@SpringBootTest
class WebCalculatorFunctionsulatorApplicationTests {

	private MockMvc mockMvc;
	private WebCalculatorService cser;
	
    public static ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = 
                new InternalResourceViewResolver();
 
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
    
	@BeforeEach
    void configureSystemUnderTest() {
        cser = mock(WebCalculatorService.class);
 
        WebCalculatorController testedController = new WebCalculatorController(cser);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(testedController)
                .setViewResolvers(jspViewResolver())
                .build();
    }
    
    @Test
	void contextLoads() throws Exception {
        this.mockMvc.perform(get("/home")).andExpect(status().isOk())
        			.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"))
        			.andExpect(view().name("home"))
//        			.andExpect(content().string("Simple Arithmetic Calculator"))
        			.andDo(MockMvcResultHandlers.print())
                    .andReturn();;

	}
	@Autowired
	private WebCalculatorService csertest;

	@Test
	@DisplayName("Test cases for validateNum function in service testcase01")
	public void testcase01() {
		System.out.println("validateNum(12)"+"true");
		assertEquals(csertest.validateNum("12"),true);

		System.out.println("validateNum(12asd)"+"true");
		assertEquals(csertest.validateNum("12asd"),false);
		
		System.out.println("validateNum(12.0)"+"true");
		assertEquals(csertest.validateNum("12.0"),true);

		System.out.println("validateNum(-12.0)"+"true");
		assertEquals(csertest.validateNum("-12.0"),true);

		System.out.println("validateOper('+')"+true);
		assertEquals(csertest.validateOper('+'),true);

		System.out.println("validateOper('-')"+true);
		assertEquals(csertest.validateOper('-'),true);

		System.out.println("validateOper('*')"+true);
		assertEquals(csertest.validateOper('*'),true);

		System.out.println("validateOper('/')"+true);
		assertEquals(csertest.validateOper('/'),true);

		System.out.println("validateOper('%')"+false);
		assertEquals(csertest.validateOper('%'),false);

		//		assertEquals(csertest.validateNum("12asd"),true);
	}

	@Test
	@DisplayName("Test cases for calculatorFunctions function in service testcase02")
	public void testcase02() {
		System.out.println("calculatorFunctions(12+123)"+"135.0");
		assertEquals(csertest.calculatorFunctions("12","123",'+'),"135.0");

		System.out.println("calculatorFunctions(12-123)"+"-111.0");
		assertEquals(csertest.calculatorFunctions("12","123",'-'),"-111.0");

		System.out.println("calculatorFunctions(123-12)"+"111.0");
		assertEquals(csertest.calculatorFunctions("123","12",'-'),"111.0");

		System.out.println("calculatorFunctions(123-123)"+"0.0");
		assertEquals(csertest.calculatorFunctions("123","123",'-'),"0.0");

		System.out.println("calculatorFunctions(12*123)"+"1476.0");
		assertEquals(csertest.calculatorFunctions("12","123",'*'),"1476.0");

		System.out.println("calculatorFunctions(120*30)"+"3600.0");
		assertEquals(csertest.calculatorFunctions("120","30",'*'),"3600.0");

		System.out.println("CalculatorFunctions(121/12)"+"11.0");
		assertEquals(csertest.calculatorFunctions("121","11",'/'),"11.0");

		System.out.println("CalculatorFunctions(12/123)"+"0.0975609756097561");
		assertEquals(csertest.calculatorFunctions("12","123",'/'),"0.0975609756097561");

		System.out.println("CalculatorFunctions(12^2)"+"0.0");
		assertEquals(csertest.calculatorFunctions("12","2",'^'),"0.0");

	}
}
