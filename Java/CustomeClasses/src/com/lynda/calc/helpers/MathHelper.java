package com.lynda.calc.helpers;

public class MathHelper {
	public static double divideValues(String s1, String s2) {
		
		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		double result = d1 / d2;
		return result;
	}//close  

	public static double multiplyValues(String s1, String s2) {
	
		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		double result = d1 * d2;
		return result;
		}//close  

	public static double subtractValues(String s1, String s2) {
	
		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		double result = d1 - d2;
		return result;
		}//close  
	
	public static double addValues(String s1, String s2)
		throws NumberFormatException {
		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		double result = d1 + d2;
		return result;
	} 
	
	
	}
