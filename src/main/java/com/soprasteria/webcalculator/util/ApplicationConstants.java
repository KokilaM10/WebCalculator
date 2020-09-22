package com.soprasteria.webcalculator.util;

/**
 * This class contains the defined values of the constants used across the main and service classes.
 * 
 * @author soprasteria
 *
 */
public class ApplicationConstants {
	
	public static final String EMSG_NULL = "";
	public static final String EMSG_INVALID_NUMBER1 = "Invalid Number1";
	public static final String EMSG_INVALID_NUMBER2 = "Invalid Number2";
	public static final String EMSG_INVALID_BOTH_NUMBERS = "Invalid Number1 & 2";
	
	public static final String HOME = "home";
	
	public static final String NUMBER1 = "num1";
	public static final String NUMBER2 = "num2";
	public static final String OPERATION = "operation";
	public static final String RESULT = "rresult";
	public static final String ERROR_MESSAGE = "eMsg";
	public static final String PARAM_RESULT = "result";
	
	public static final char ADD = '+';
	public static final char SUBTRACT = '-';
	public static final char MULTIPLY = '*';
	public static final char DIVIDE = '/';
	public static final String HUNDREDTH_PLACE = "%.2f";
	
	public static final String FORWARDED_URL = "/WEB-INF/jsp/home.jsp";
	
	private ApplicationConstants() {
		
	}
	
}
