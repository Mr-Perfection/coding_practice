import java.io.BufferedReader;
import java.io.InputStreamReader;

public class calculator2 {
	
	public static void main(String[] args) {
	///Declare inputs.
		String s1 = getInput("Enter a numeric value 1: ");
		String s2 = getInput("Enter a numeric value 2: ");
		
		String op = getInput("Enter 1=Add, 2=Subtract, 3=Multiply, 4=Divide");
		double result=0;
		
		
		switch (op) {
		case "1":
			result = addValues(s1, s2);
			break;
		
		case "2":
			result = subtractValues(s1, s2);
			break;
		
		case "3":
			result = multiplyValues(s1, s2);
			break;
		case "4":
			result = divideValues(s1, s2);
			break;
		default:
			System.out.println("Please enter a correct value from 1 to 4.");
			return;
		
		}
		
		
		System.out.println("The answer is= " + result);
		
		
	}// close public static main() 

	private static double divideValues(String s1, String s2) {
			throws NumberFormatException {
				double d1 = Double.parseDouble(s1);
				double d2 = Double.parseDouble(s2);
				double result = d1 / d2;
				return result;
			}//close  

	private static double multiplyValues(String s1, String s2) {
		throws NumberFormatException {
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			double result = d1 * d2;
			return result;
			}//close  

	private static double subtractValues(String s1, String s2) {
		throws NumberFormatException {
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			double result = d1 - d2;
			return result;
			}//close  

	private static double addValues(String s1, String s2)
			throws NumberFormatException {
		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		double result = d1 + d2;
		return result;
	} 

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
	 }


