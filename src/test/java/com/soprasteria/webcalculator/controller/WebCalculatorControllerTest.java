package com.soprasteria.webcalculator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.soprasteria.webcalculator.service.WebCalculatorService;
import com.soprasteria.webcalculator.util.ApplicationConstants;

/**
 * 
 * This is the test class for the controller class.
 * 
 * @author soprasteria
 *
 */
@SpringBootTest
class WebCalculatorControllerTest {

	private MockMvc mockMvc;
	@Autowired
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
    void setup() {
 
        WebCalculatorController testedController = new WebCalculatorController(cser);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(testedController)
                .setViewResolvers(jspViewResolver())
                .build();
    }
    
	@DisplayName("Testing showWebCalculatorPage GET function in controller")
 	@Test
	void testshowWebCalculatorPageGET() throws Exception {
        this.mockMvc.perform(get("/home"))
        	.andExpect(status().isOk())
        	.andExpect(forwardedUrl(ApplicationConstants.FORWARDED_URL))
        	.andExpect(view().name(ApplicationConstants.HOME))
        	.andDo(MockMvcResultHandlers.print())
        	.andReturn();
	}

	@DisplayName("01 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void testshowWebCalculatorResultPageVALIDRESULT() throws Exception {
        this.mockMvc.perform(post("/home")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param(ApplicationConstants.NUMBER1,"100")
                    .param(ApplicationConstants.NUMBER2,"200")
                    .param(ApplicationConstants.OPERATION, "+")
                    .param(ApplicationConstants.PARAM_RESULT,""))
                    .andExpect(status().isOk())
                    .andExpect(view().name(ApplicationConstants.HOME))
                    .andExpect(forwardedUrl(ApplicationConstants.FORWARDED_URL))
                    .andExpect(model().attributeExists(ApplicationConstants.RESULT))
                    .andExpect(model().attribute(ApplicationConstants.RESULT,"300.00"))
                    .andExpect(model().attribute(ApplicationConstants.ERROR_MESSAGE,""))
                    .andDo(MockMvcResultHandlers.print());
	}

	@DisplayName("02 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void testshowWebCalculatorResultPageInvalidNum1and2() throws Exception {
        this.mockMvc.perform(post("/home")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param(ApplicationConstants.NUMBER1,"100a")
                .param(ApplicationConstants.NUMBER2 , "200a")
                .param(ApplicationConstants.OPERATION, "+")
                .param(ApplicationConstants.PARAM_RESULT,""))
                .andExpect(status().isOk())
                .andExpect(view().name(ApplicationConstants.HOME))
                .andExpect(forwardedUrl(ApplicationConstants.FORWARDED_URL))
                .andExpect(model().attribute(ApplicationConstants.ERROR_MESSAGE,"Invalid Number1 & 2"))
                .andDo(MockMvcResultHandlers.print());
	}
	@DisplayName("03 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void testshowWebCalculatorResultPageInvalidNum1() throws Exception {
        this.mockMvc.perform(post("/home")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param(ApplicationConstants.NUMBER1,"100a")
                .param(ApplicationConstants.NUMBER2 , "200")
                .param(ApplicationConstants.OPERATION, "+")
                .param(ApplicationConstants.PARAM_RESULT,""))
                .andExpect(status().isOk())
                .andExpect(view().name(ApplicationConstants.HOME))
                .andExpect(forwardedUrl(ApplicationConstants.FORWARDED_URL))
                .andExpect(model().attribute(ApplicationConstants.ERROR_MESSAGE,"Invalid Number1"))
                .andDo(MockMvcResultHandlers.print());
	}
	@DisplayName("04 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void testshowWebCalculatorResultPageInvalidNum2() throws Exception {
        this.mockMvc.perform(post("/home")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param(ApplicationConstants.NUMBER1,"100")
                .param(ApplicationConstants.NUMBER2 , "200a")
                .param(ApplicationConstants.OPERATION, "+")
                .param(ApplicationConstants.PARAM_RESULT,""))
                .andExpect(status().isOk())
                .andExpect(view().name(ApplicationConstants.HOME))
                .andExpect(forwardedUrl(ApplicationConstants.FORWARDED_URL))
                .andExpect(model().attribute(ApplicationConstants.ERROR_MESSAGE,"Invalid Number2"))
                .andDo(MockMvcResultHandlers.print());
	}
}
