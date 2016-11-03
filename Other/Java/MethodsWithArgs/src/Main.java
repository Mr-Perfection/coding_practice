
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
	//type the numeric value
		String s1 = getInput("Enter a numeric value 1: ");
		String s2 = getInput("Enter a numeric value 2: ");
		
		double n1 = Double.parseDouble(s1);
		double n2 = Double.parseDouble(s2);
		double result = Math.round(((n1 + n2)*100.0))/100.0;
		double result1 = Math.round(((n1 * n2)*100.0))/100.0;
		double result2 = Math.round(((n1 / n2)*100.0))/100.0;
		
		double resultOfMultiple = addMultipleValues(1,2,3,4,5);
		System.out.println("The answer for multiple values is " + resultOfMultiple);
		System.out.println("Value 1 + Value 2 = " + result);
		System.out.println("Value 1 * Value 2 = " + result1);
		System.out.println("Value 1 / value 2 = " + result2);
		
	} //public static main() ends 

	 private static String getInput(String prompt) {
		
		 BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.print(prompt);
		System.out.flush();
		
		try{
			return stdin.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
			} //close  
		}
	 
	private static double addMultipleValues(double ...values){
		double result = 0d;
		for (double d : values) {
			result += d;
			
		} //for loop ends
		return result;
			
		} //private staic double addMult ends
	} //class ends
