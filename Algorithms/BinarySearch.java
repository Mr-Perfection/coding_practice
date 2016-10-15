import java.util.Scanner;
import java.util.Arrays;


public class BinarySearch
{
/****
	@param array must be sorted in ascending order.
	@param key the serach key
	****/

	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		int i,j;
		
		int[] array = new int[10];
		System.out.print("Input array elements["+array.length+"]: ");
		for(i=0;i<array.length-1;++i)
		{
			array[i] = sc.nextInt();	//store the integer into the array.
		}
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.print("Value you are looking for: ");
		int key = sc.nextInt();
		binarySearch(array, 0,array.length -1,key);
	}

	public static void binarySearch(int[] array, int lowerbound, int upperbound, int key)
	{
		int position;
    	int comparisonCount = 1;    // counting the number of comparisons (optional)
    	// To start, find the subscript of the middle position.
     	position = (lowerbound + upperbound) / 2;
     	while((array[position] != key) && (lowerbound <= upperbound))
     	{
     		comparisonCount++;
     		 if (array[position] > key)             // If the number is > key, ..
     		 {
     		 	upperbound = position - 1; //Decrease the position by 1.
     		 }
     		 else
     		 {
     		 	 lowerbound = position + 1;    // Else, increase position by 1. 
     		 }
     		 position = (lowerbound + upperbound) / 2; //Find the half of new low + upper
     	}//EOF while
     	if (lowerbound <= upperbound)
     	{
           System.out.println("The number was found in array subscript" + position);
           System.out.println("The binary search found the number after " + comparisonCount +
                 "comparisons.");
           // printing the number of comparisons is optional
     	}
     	else
          System.out.println("Sorry, the number is not in this array.  The binary search made "
                 +comparisonCount  + " comparisons.");
  	}//EOF binarySearch

}