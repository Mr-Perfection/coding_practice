import java.io.*; //for get.input function

public class doggystyle {
public static void main( String[] args){
	String month = getInput("Enter this month: ");
	double d1 = Math.round(Double.parseDouble(month));
	
	if (d1 == 1){
		System.out.println("You are lucky because it is January!!");
		
	}// if statement ends
	else {
		System.out.println("You are the loser bitch!");
	}
} // end public  void main()

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
