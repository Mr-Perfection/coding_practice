
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SwitchWithEnums {
	
	public static void main(String[] args) {
		
		Month month = Month.FEBUARY;
		//int month = Integer.parseInt(Input);
		switch (month) {
		case JANUARY:
			System.out.println("The month is January");
			break;
		case FEBUARY:
			System.out.println("The month is Febuary");
			break;
		case MARCH:
			System.out.println("The month is March");
			break;
		default:
			System.out.println("Error: Please, enter the valid number!");
			break;
		} //close switch
	}// close public main()

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
		} //close private getInput()

	} // end class doggystyle()

