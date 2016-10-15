import java.util.HashMap;


public class Main {

	
	public static void main(String[] args) {
	
	HashMap<String, String> map = new HashMap<>();
	map.put("California", "Sacremento");
	map.put("Niggas", "Black");
	map.put("Asians", "Brownish");
	System.out.println(map);
	
	map.put("Europeans", "Pale");
	System.out.println(map);
	
	String s1= map.get("Niggie");
	System.out.println("The skin color of black people is: " + s1);
	}//end public static void main()

}//end class Main()
