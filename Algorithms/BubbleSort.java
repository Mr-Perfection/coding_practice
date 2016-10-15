public class BubbleSort
{

	public static void main(String[] args) 
	{	
		int i, j;
		int[] array = new int[5];
		int temp;
		for(i =0; i < array.length; ++i)
		{
			for(j=0; j < array.length; ++j)
			{
				if(array[i] > array[j+1])	//sort from smallest to largest value
				{
					temp = array[j+1];
					array[j+1] = array[i];
					array[i] = temp;
				}
			}
		}

	}
}