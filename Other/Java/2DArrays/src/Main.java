
public class Main {

	
	
	public static void main(String[] args) {
	
		String[][] states = new String[3][2];
		states[0][0] = "California";
		states[0][1]= "LA Bitches";
		states[1][0] = "Yolo City";
		states[1][1]= "WhiteAssholes";
		states[2][0] = "NiggaLand";
		states[2][1]= "I have a big D";
		
		for (int i = 0; i < states.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < states[i].length; j++) {
				if (j == 0) {
					sb.append("The capital of ");
				} // if statement ends
				else {sb.append(" is ");
					
				}//else block ends
				sb.append(states[i][j]);
			} //inner for loop states ends
			System.out.println(sb);
		}// outer for loop states ends
	
	}//public static void main() ends

}//class Main() ends
