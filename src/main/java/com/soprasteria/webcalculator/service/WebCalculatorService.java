//Backend calculator functions are defined here
//This class is having method to validate the number & calculations 
package com.soprasteria.webcalculator.service;

import org.springframework.stereotype.Service;

import com.soprasteria.webcalculator.util.ApplicationConstants;

/**
 *
 *This class is having methods to validate the number & calculations. 
 *Back-end calculator functions are defined here.
 * 
 * @author soprasteria
 *
 */
@Service
public class WebCalculatorService {
	
	// this function validates the input number before calculation
    public boolean validateNum(String num) {
    	try{
    		Double.parseDouble(num);
    		return true;
    	}
    	catch (NumberFormatException e) {
    		return false;
    	}
    }
    
    public boolean validateOper(char oper) {
    	switch(oper) {
		case ApplicationConstants.ADD:
		case ApplicationConstants.SUBTRACT:
		case ApplicationConstants.MULTIPLY:
		case ApplicationConstants.DIVIDE:
    		return true;
    	default:
    		return false;
    	}
    }
    
    // this function do the calculation on the input numbers
    public String calculatorFunctions(String num1,String num2,char operation) {
    	Double dnum1 = Double.parseDouble(num1);
    	Double dnum2 = Double.parseDouble(num2);
    	Double res = 0.00;
    	switch (operation) {
    		case ApplicationConstants.ADD:
    			res = dnum1 + dnum2;
    			break;
			case ApplicationConstants.SUBTRACT:
    			res = dnum1 - dnum2;
    			break;
			case ApplicationConstants.MULTIPLY:
    			res = dnum1 * dnum2;
    			break;
			case ApplicationConstants.DIVIDE:
    			res = dnum1 / dnum2;
    			break;
    		default:
    	}
        return Double.toString(res);
    }

}
