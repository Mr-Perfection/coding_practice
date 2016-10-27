public class Solution {
	public int longestConsecutive(final List<Integer> a) {
	    //sort list
	    //System.out.println("LIST: " + list);
	    int n = a.size();
	    //List<Integer> list = new ArrayList<Integer>();
	    Set<Integer> set = new HashSet<Integer>();
	    int count = 0;
	    int i = 0;
	    //add to the set.
	    for(i = 0; i < n; ++i)
	    {
	    	set.add(a.get(i));
	    }
	    
	    //use hashing
	    // check each possible sequence from the start
        // then update optimal length
       
	    for (i = 0; i < n; ++i)
	    {
	    	//first non-decreasing number
	    	if(!set.contains(a.get(i) - 1))
	    	{
	    		int j = a.get(i);
	    		while (set.contains(j))
	    			j++;
	    		//if count is less than j - a.get(i) --the length of the subsequence
	    		if (count < j - a.get(i))
	    			count = j - a.get(i);
	    	}

	    }
	    
	    return (count);
	}
}
