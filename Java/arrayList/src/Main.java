import java.util.ArrayList;


public class Main {

	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		list.add("CornyLand");
		list.add("California");
		list.add("HornDogs");
		//list.set(2, "HornDogs");
		
		System.out.println(list);
		
		int pos1 = list.indexOf("HornDogs");
		System.out.println("HornDogs is at position: " + pos1);
		//HornDogs is at position 2.
		list.add("KimJungUn");
		System.out.println(list);
		
		list.remove(0);
		System.out.println(list);
		
		String state = list.get(1);
		System.out.println("The second state is " + state);
		
		
		int pos= list.indexOf("HornDogs");
		System.out.println("HornDogs is at position: " + pos);
		/*HornDogs is at position 1. I guess it got shifted since
		KimJungUn was added to the arraylist.*/
	}//end public static void main()
}//end class Main()
