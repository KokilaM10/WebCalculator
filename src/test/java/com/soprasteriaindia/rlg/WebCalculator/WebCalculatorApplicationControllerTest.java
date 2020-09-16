package com.soprasteriaindia.rlg.WebCalculator;

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

import com.soprasteriaindia.rlg.WebCalculator.controller.WebCalculatorController;
import com.soprasteriaindia.rlg.WebCalculator.service.WebCalculatorService;

@SpringBootTest
class WebCalculatorApplicationControllerTest {

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
    void configureSystemUnderTest() {
 
        WebCalculatorController testedController = new WebCalculatorController(cser);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(testedController)
                .setViewResolvers(jspViewResolver())
                .build();
    }
    
	@DisplayName("Testing showWebCalculatorPage GET function in controller")
 	@Test
	void showWebCalculatorPageTest() throws Exception {
        this.mockMvc.perform(get("/home"))
        	.andExpect(status().isOk())
        	.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"))
        	.andExpect(view().name("home"))
        	.andDo(MockMvcResultHandlers.print())
        	.andReturn();
	}

	@DisplayName("01 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void showWebCalculatorResultPageTest01() throws Exception {
        this.mockMvc.perform(post("/home")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("num1","100")
                    .param("num2","200")
                    .param("operation", "+")
                    .param("result",""))
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"))
                    .andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"))
                    .andExpect(model().attributeExists("rresult"))
                    .andExpect(model().attribute("rresult","300.0"))
                    .andExpect(model().attribute("eMsg",""))
                    .andDo(MockMvcResultHandlers.print());
	}

	@DisplayName("02 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void showWebCalculatorResultPageTest02() throws Exception {
        System.out.println("second POST");
        this.mockMvc.perform(post("/home")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("num1","100a")
                .param("num2" , "200a")
                .param("operation", "+")
                .param("result",""))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"))
                .andExpect(model().attribute("eMsg","Invalid Number1 & 2"))
                .andDo(MockMvcResultHandlers.print());
	}
	@DisplayName("03 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void showWebCalculatorResultPageTest03() throws Exception {
        System.out.println("second POST");
        this.mockMvc.perform(post("/home")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("num1","100a")
                .param("num2" , "200")
                .param("operation", "+")
                .param("result",""))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"))
                .andExpect(model().attribute("eMsg","Invalid Number1"))
                .andDo(MockMvcResultHandlers.print());
	}
	@DisplayName("04 Testing showWebCalculatorResultPage POST function in controller")
 	@Test
	void showWebCalculatorResultPageTest04() throws Exception {
        System.out.println("second POST");
        this.mockMvc.perform(post("/home")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("num1","100")
                .param("num2" , "200a")
                .param("operation", "+")
                .param("result",""))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"))
                .andExpect(model().attribute("eMsg","Invalid Number2"))
                .andDo(MockMvcResultHandlers.print());
	}
}
