//Given an array of integers, return the highest product possible by multiplying 3 numbers from the array
/*
[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000, consecutive three numbers

*/

public class Solution {
	
	public int[] ft_get_greater_three (ArrayList<Integer> a)
	{
		//this helper will get the two  second and third greatest numbers in list.
		int max[] = new int[3];// 1 4 2 -7 -2 10
		Arrays.fill( max, Integer.MIN_VALUE);
		for(int i = 0; i < a.size(); i++){
			int item = a.get(i);
	        if(item >= max[0]){
	            max[2] = max[1];
	            max[1] = max[0];
	            max[0] = item;
	        } else if(item >= max[1]){
	            max[2] = max[1];
	            max[1] = item;
	        } else if(item >= max[2]){
	            max[2] = item;
	        }
	    }
		return (max);
	}
	public int[] ft_get_smaller_two (ArrayList<Integer> a)
	{
		//this helper will get the two smallest numbers
		int min[] = new int[2];// 1 4 2 -7 -2 10
		//min[0] = second lowest, min[1] = lowest
		Arrays.fill( min, Integer.MAX_VALUE);
		int i = 0;
		while(i < a.size())
		{
			int item = a.get(i);
			
			if (min[0] >= item)
			{
				min[1] = min[0];
				min[0] = item;
			}
			else if ( min[1] >= item)
				min[1] = item;
			i++;
		}
		return (min);
	}
    public int maxp3(ArrayList<Integer> a) {
    	int max = 0;
    	int[] three_g = ft_get_greater_three(a);
    	int[] two_l = ft_get_smaller_two(a);
    	//System.out.println("greatest: " + g);
    	//System.out.println("two greater: " + three_g[0] + " " + three_g[1]);
    	//System.out.println("two lower: " + two_l[0] + " " + two_l[1]);
    	max = Math.max( three_g[0] * three_g[1] * three_g[2], three_g[0] * two_l[0] * two_l[1]);
    	return (max);
    }
}
