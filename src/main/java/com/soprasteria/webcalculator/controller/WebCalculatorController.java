package com.soprasteria.webcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soprasteria.webcalculator.service.WebCalculatorService;
import com.soprasteria.webcalculator.util.ApplicationConstants;

/**
 * 
 * This is controller class which handles GET/POST to the web page
 * 
 * @author soprasteria
 *
 */
@Controller
public class WebCalculatorController {
	WebCalculatorService wCS;
	
	public WebCalculatorController(WebCalculatorService wcs){
		this.wCS = wcs;
	}
	
	@GetMapping(path="/home")
    public String showWebCalculatorPage(ModelMap model) {
		return ApplicationConstants.HOME;
	}

	@PostMapping(path="/home")
    public String showWebCalculatorResultPage(ModelMap model, 
    											@RequestParam String num1,  
    											@RequestParam String num2, 
    											@RequestParam char operation, 
    											@RequestParam String result){
		String errorMessage = ApplicationConstants.EMSG_NULL;
		boolean isValidnum1 = wCS.validateNum(num1);
		boolean isValidnum2 = wCS.validateNum(num2);

		if (!isValidnum1) {
			errorMessage = ApplicationConstants.EMSG_INVALID_NUMBER1;
		}
		if (!isValidnum2) {
			errorMessage = ApplicationConstants.EMSG_INVALID_NUMBER2;
		}
		if (!isValidnum1 && !isValidnum2) {
			errorMessage = ApplicationConstants.EMSG_INVALID_BOTH_NUMBERS;
		}
		model.put(ApplicationConstants.NUMBER1,num1);
		model.put(ApplicationConstants.NUMBER2,num2);
		model.put(ApplicationConstants.OPERATION,operation);
	    if (isValidnum1 && isValidnum2) {
	    	result = wCS.calculatorFunctions(num1,num2,operation);
	    }
		model.put(ApplicationConstants.RESULT,result);
		model.put(ApplicationConstants.ERROR_MESSAGE,errorMessage);
		return ApplicationConstants.HOME;
    }
}
