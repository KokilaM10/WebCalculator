//Backend calculator functions are defined here
//This class is having method to validate the number & calculations 
package com.soprasteriaindia.rlg.WebCalculator.service;

import org.springframework.stereotype.Service;

@Service
public class WebCalculatorService {
	// this function validate the input number before calculation
    public boolean validateNum(String num) {
    	try{
    		Double.parseDouble(num);
    		return true;
    	}
    	catch (NumberFormatException e) {
    		return false;
    	}
    }
    
    public boolean validateOper(char Oper) {
    	switch(Oper) {
    	case '+':
    	case '-':
    	case '*':
    	case '/':
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
    		case '+':
    			res = dnum1 + dnum2;
    			break;
    		case '-':
    			res = dnum1 - dnum2;
    			break;
    		case '*':
    			res = dnum1 * dnum2;
    			break;
    		case '/':
    			res = dnum1 / dnum2;
    			break;
    	}
//    	System.out.println("dnum1="+dnum1);
//    	System.out.println("dnum2="+dnum2);
//    	System.out.println("res="+res);
//    	System.out.println("<=====>");
        return Double.toString(res);
    }

}
