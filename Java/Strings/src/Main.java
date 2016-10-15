
public class Main {
	public static void main(String[] args) {
		String s1 ="WElcome to California!";
		String s2 = new String("Welcome to California!");
		System.out.println(s1);
		System.out.println(s2);
		
		comopareTwoValues(s1, s2);
		
		charFromString(s1);
	} //end public static void main()

	private static void charFromString(String s1) {
		char[] chars = s1.toCharArray();
		for (char c : chars) {
			System.out.println(c);
		} //for loop ends
	}

	private static void comopareTwoValues(String s1, String s2) {
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("they match!");
			} // if ends
		else {System.out.println("they don't match!");
		} // else statement ends
	}
	

}
