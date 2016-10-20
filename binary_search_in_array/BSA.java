public class BinarySearchArray {
	public BinarySearchArray(){

	}
	public static boolean iterativeApproach(int array[], int left, int right, int x)
	{
		if (left > right)
			return (false);
		//until left reaches right
		while (left <= right)
		{
			//middle index
			int mid = left + (right - left) / 2;
			//check if the value of array[mid] is less or greater than x
			if (x == array[mid])
				return (true);
			else if (x < array[mid])
				right = mid - 1;
			else if (x > array[mid])
				left = mid + 1;
		}
	} 
	public static boolean recursiveApproach(int array[], int left, int right, int x)
	{
		if (left > right)
			return (false);
		int mid = (left + right) / 2;
		if (x < array[mid])
			return (recursiveApproach(array, left, mid - 1, x));
		else if (x > array[mid])
			return (recursiveApproach(array, mid + 1, right, x));
		else
			return (true);
	}

}