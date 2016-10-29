public class Solution {
	public int majorityElement(final List<Integer> a) {
	    //assume  that the array is non-empty and the majority element always exist in the array.
	    /**
		ex) 
		3 3 4 2 4 4 2 4 4
		1. sort first.
		2 2 3 3 4 4 4 4 4
		2. count the number of occurences
		2 2 3 3 4 4 4 4 4
	dp: 1 2 1 2 1 2 3 4 5
		3.iterate through dp and find the max (and check if its greater than n/2) and get the index.
		5, i = 8	
		
		OR (since the parameter is final... assume it wants to approach differently)
		
		3 3 4 2 4 4 2 4 4
		
	    **/
	    int n = a.size();
	    int i;
	    int m = n / 2;
	    int count =  0;
	    int[] dp = new int[n];
	    List<Integer> list = new ArrayList<Integer>();
	    for (i = 0; i < n; ++i)
	    {
	    	list.add(a.get(i));
	    }
	    Collections.sort(list);
	    Arrays.fill(dp, 1);
	    for (i = 0; i < n - 1; ++i)
	    {
	    	System.out.println("dp: " + dp[i] + " " + list.get(i - 1) + " " + list.get(i));
	    	if (list.get(i) == list.get(i + 1))
	    		dp[i + 1] = dp[i] + 1;
	    }

	    int max = Integer.MIN_VALUE;
	    int dp_size = dp.length;
	    int maj_element = list.get(dp_size - 1);
	    for (i = dp_size - 1; i >= 0; --i )
	    {
	    	int item = dp[i];
	    	if (item > max)
	    	{
	    		max = item;
	    		// System.out.println("max: " + max);
	    		maj_element = list.get(i);
	    		// System.out.println("majority: " + maj_element);
	    	}
	    }
	    return (maj_element);
	}
}




public class Solution {
    
    
    
    /* Function to find the candidate for Majority */
    int findCandidate( final List<Integer> a, int size) 
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) 
        {
            if (a.get(maj_index) == a.get(i))
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return (a.get(maj_index));
    }
    
	public int majorityElement(final List<Integer> a) {
	    int n = a.size();
	    return (findCandidate(a, n));  
	}  
}
