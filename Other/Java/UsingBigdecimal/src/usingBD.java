
public class usingBD {
	
	
	public static void main(String[] args) {
		double d = 1115.37;
		String ds = Double.toString(d);
		BigDecimal bd = new BigDecimal(ds);
		
		System.out.println("The value of my payment is: " + bd.toString());

	}

}
