public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> list, int target) {
	   
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int n = list.size();
	    ArrayList<Integer> result = new ArrayList<Integer>();

	    for (int i = 0; i < n ; ++i)
	    {
	    	if (map.containsKey(list.get(i)))
	    	{
	    		result.add(map.get(list.get(i)));//index1
	    		result.add(i + 1); //index2
	    		break;
	    	}
	    	else
	    	{
	    		int key = target - list.get(i);
	    		if (map.containsKey(key))
	    			map.put(key, Math.min( map.get(key) ,i + 1)); //check minimum index1
	    		else
	    			map.put(key, i + 1); 
	    	    
	    	}
	    }

	    return (result);
	}
}





//bad implementation... but working. Time complex. : O(n^2)
public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> list, int target) {
	   
	    ArrayList<Integer> index1 = new ArrayList<Integer>();
	    ArrayList<Integer> index2 = new ArrayList<Integer>();
	    ArrayList<Integer> indices1 = new ArrayList<Integer>();
	    ArrayList<Integer> solution = new ArrayList<Integer>();
	    int n = list.size();
	    int i, j;
	    //no repeated list items
	    for ( i = 0; i < n; ++i)
	    {
	    	for( j = i + 1; j < n; ++j )
	    	{
	    		//solution found? save indices
	    		if ((list.get(i) + list.get(j)) == target)
	    		{
	    			index1.add(i + 1);
	    			index2.add(j + 1);
	    		}
	    	}
	    }
	     //System.out.println("index1 " + index1);
	    //System.out.println("index2 " + index2);
	    //index1 [1, 1, 3, 4, 4, 5, 5, 6, 6, 11, 13, 13, 13, 15, 18, 19, 19, 25, 26]
	    //index2 [13, 26, 19, 8, 24, 8, 24, 8, 24, 19, 18, 25, 30, 21, 26, 20, 29, 26, 30]
	    //If multiple solutions exist, output the one where index2 is minimum
	    
	    if (index2.size() > 1)
	    {
	    	int min = Integer.MAX_VALUE;
	    	int count = 0;
	    	int x = 0; //this will save the i th index.
	    	
	    	for(i = 0; i < index2.size(); ++i)
	    	{
	    		int temp = index2.get(i);
	    		if (temp == min)
	    		{
	    			count += 1;
	    			indices1.add(index1.get(i));
	    		}	
	    		if (temp < min)
	    		{
	    			indices1.clear();
	    			indices1.add(index1.get(i));
	    			min = temp;
	    			x = i;
	    		}
	    	}
	    	if (count != 0)
	    	{
	    		//choose the one with the minimum index1
	    		min = Integer.MAX_VALUE;
	    		int  k = 0;
	    		for(i = 0; i < indices1.size(); ++i)
		    	{
		    		int temp = indices1.get(i);
		    		if (temp < min)
		    		{
		    			min = temp;
		    			k = i;
		    		}
		    	}
	    		solution.add(indices1.get(k));
	    		solution.add(index2.get(x));
	    	}
	    	else
	    	{
	    		solution.add(index1.get(x));
	    		solution.add(index2.get(x));
	    	}
	    }
	    else if (index2.size() == 1){

	        solution.add(index1.get(0));
	        solution.add(index2.get(0));
	    }
	    return (solution);
	}
}
