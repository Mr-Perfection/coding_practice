public class Solution {
	public static void quicksort(int array[]) {
		quicksort(array, 0, array.length - 1);
	}

	public static void quicksort(int array[], int left, int right)
	{
		if (left > right)
			return ;
		//middle index & pivot value
		int pivot = array[(left + right) / 2];
		//get the index that will devide the array.
		int index = partition(array, left, right, pivot);
		//sort the left side of partitioned array.
		quicksort(array, left, index - 1);
		//sort the right side of partitioned array.
		quicksort(array, index, right);
	}

	public static int partition(int array[], int left, int right, int pivot)
	{
		while (left <= right)
		{
			//find the first index that element value is greater than pivot
			while (array[left] < pivot)
				left++;
			//find the first index that the element value is less than pivot
			while (array[right] > pivot)
				right--;
			//if left is less or equal to right
			if (left <= right)
			{
				swap(array, left, right);
				left++;
				right--;
			}
		} //EOF while
		return (left);


	}

	public static void swap(int array[], int left, int right)
	{
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}