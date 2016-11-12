/**
A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max
 	 
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array. 


**/


public class Solution {
	// DO NOT MODIFY THE LIST
	public static int get_max(final List<Integer> a, int i, int n)
	{
		int max = Integer.MIN_VALUE;
		for(int j = i; j < i + n; ++j)
			max = Math.max(max, a.get(j));
		return (max);
	}
	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int n) {
	    
	    ArrayList<Integer> window = new ArrayList<Integer>();
	    ArrayList<Integer> sol = new ArrayList<Integer>();
	    for (int i = 0; i < a.size() - n + 1; ++i)
	    	sol.add(get_max(a, i, n));
	    return (sol);
	}
}

public class Solution {
	// DO NOT MODIFY THE LIST
	public static int get_max(final List<Integer> a, int i, int n)
	{
		int max = Integer.MIN_VALUE;
		for(int j = i; j < n; ++j)
			max = Math.max(max, a.get(j));
		return (max);
	}
	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int n) {
	    
	   // ArrayList<Integer> window = new ArrayList<Integer>(a);
	   ArrayList<Integer> window = new ArrayList<Integer>();
	    ArrayList<Integer> sol = new ArrayList<Integer>();
	    int cnt = 0;
	    int i = 0;
	    int max = 0;
	    if (a.size() == 0)
	        return (null);
	   
	   //get the first n number of elements
	   for (i = 0; i < n; ++i)
	    window.add(a.get(i));
	   max = get_max(a, 0, n);
	   sol.add(max);
	   for (i = n; i < a.size(); ++i)
	   {
	       window.remove(0);
	       window.add(a.get(i));
	       max = get_max(window, 0, n);
	       sol.add(max);
	   }
	   
	   // while (!window.isEmpty())
	   // {
	   //     if (i < n - 1)
	   //         max = Math.max(max, window.get(i));
	   //     else 
	   //     {
	   //         if (window.size() <= i)
	   //             return (sol);
	   //         max = Math.max(max, window.get(i));
	   //         sol.add(max);
	   //         window.remove(0);
	   //         max = 0;
	   //         i = -1;
	   //     }
	   //     i++;
	   // }
	   
	    
	    return (sol);
	}
}





//Most optimal solution

public class Solution {
	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int k) {
		if (a == null || a.size() == 0 || k <= 0) 
			return (new ArrayList<Integer>(0));
		LinkedList<Integer> dq = new LinkedList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>(a.size() - k + 1);
		int index = 0;
		int j = 0;
		for (int i = 0; i < a.size(); ++i)
		{
			index  = i - k + 1;
			
			while (!dq.isEmpty() && dq.peek() < index)
				dq.poll();	//remove the element at the head index
			
			while (!dq.isEmpty() && a.get(dq.peekLast()) <= a.get(i))
				dq.pollLast();	//remove element at last index or tail index.
			dq.offer(i);
			if (index >= 0)
			{
				ans.add(j, a.get(dq.peek()));
				j++;
			}
            
		}
		return ans;

	}

}