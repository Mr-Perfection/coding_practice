
public class Main {

	public static void main(String[] args) {
		try {
			getArrayItem();
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Array was out of balance.");
		}
		

	} //static void main() ends

	private static void getArrayItem()
			throws ArrayIndexOutOfBoundsException {
	
		String[] strings = {"Welcome!"};
		System.out.println(strings[1]);
	} //throws the exception? ends

}//class ends
