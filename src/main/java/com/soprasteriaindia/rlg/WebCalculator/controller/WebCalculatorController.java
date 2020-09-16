// This is controller class which handles GET/POST
package com.soprasteriaindia.rlg.WebCalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soprasteriaindia.rlg.WebCalculator.service.WebCalculatorService;

@Controller
public class WebCalculatorController {
	WebCalculatorService wCS;
	
	public WebCalculatorController(WebCalculatorService wcs){
		this.wCS = wcs;
	}
	
	@GetMapping(path="/home")
    public String showWebCalculatorPage(ModelMap model) {
		return "home";
	}

	@PostMapping(path="/home")
    public String showWebCalculatorResultPage(ModelMap model, 
    											@RequestParam String num1,  
    											@RequestParam String num2, 
    											@RequestParam char operation, 
    											@RequestParam String result){
		String errorMessage = "";
		boolean isValidnum1 = wCS.validateNum(num1);
		boolean isValidnum2 = wCS.validateNum(num2);

		if (!isValidnum1) {
			errorMessage = "Invalid Number1";
		}
		if (!isValidnum2) {
			errorMessage = "Invalid Number2";
		}
		if (!isValidnum1 && !isValidnum2) {
			errorMessage = "Invalid Number1 & 2";
		}
		model.put("num1",num1);
		model.put("num2",num2);
		model.put("operation",operation);
	    if (isValidnum1 && isValidnum2) {
	    	result = wCS.calculatorFunctions(num1,num2,operation);
	    }
		model.put("rresult",result);
		model.put("eMsg",errorMessage);
		return "home";
    }
}
