public class Solution {
    

    public int ft_maxProduct_helper( HashMap<Integer, Integer> solutions, final List<Integer> list, int index)
    {
    	//terminating condition: if index reaches max. size of list.
    	if (index >= list.size())
    	{
    		int i = 0;
			int max = Integer.MIN_VALUE;
			//find the max. value.
			while (i < index)
			{
				System.out.println("hashmap: key: "+ i + "value: " + solutions.get(i));
				if (solutions.get(i) > max)
					max = solutions.get(i);
				i++;
			}
			return (max);
    	}
    	//the current item in the list.
    	int item = list.get(index);
    	if (item != 0)
    	{
	    	if ( index > 0)
	    	{
	    		int prev = solutions.get(index - 1);
	    		int sol = prev * item;
	    		if (prev != 0)
	    		{
	    			//check if the sol is equal to item * list(index - 1)
	    			int  temp = item * list.get(index - 1);
	    			if (temp != sol)
	    				solutions.put(index, Math.max(temp, sol));
	    			else
	    				solutions.put( index, sol);
	    		}
	    		else
	    			solutions.put( index, item);
	    	}
	    	else
	    		solutions.put( index, item);
	    }
	    else
	    	solutions.put (index, item);

    	return ft_maxProduct_helper(solutions, list, index + 1);
    }
	public int maxProduct(final List<Integer> list) {
		int n = list.size();
		int[] max = new int[n];
		int[] min = new int[n];
		//first item of list
		int item = list.get(0);
		int result = item;
		min[0] = max[0] = item;
	    //2 3 0 5 -4
	    for(int i=1; i<nums.length; i++){
	    	item = list.get(i);
	        if(item > 0){
	            max[i] = Math.max(item, max[i-1] * item); //6 5
	            min[i] = Math.min(item, min[i-1] * item); //3 0
	        }else{
	            max[i] = Math.max(item, min[i-1] * item);//0 -4
	            min[i] = Math.min(item, max[i-1] * item);//0 -20
	        }
	 
	        result = Math.max(result, max[i]); //6 6 6
	    }
	 
	    return result;
	}
}
