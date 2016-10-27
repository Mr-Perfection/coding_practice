import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class Main {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		GregorianCalendar gc = new GregorianCalendar(2014, 2, 31);
		gc.add(GregorianCalendar.DATE, 1);
		Date d2 = gc.getTime();
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		//Format the date into full! Meaning showing a full date.
		String sd= df.format(d2);
		/*Create another String to use Dataformat for 
		 * date d2. Then, print out.
		 */
		System.out.println(sd);
		
	}

}
