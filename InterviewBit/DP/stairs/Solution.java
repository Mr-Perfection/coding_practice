public class Solution {

	//recursive way
	public int climbStairs(int target) {
	    if (target == 0)
	        return (1);
	    else if (target < 0)
	        return (0);
	   return (climbStairs(target - 1) + climbStairs(target - 2));
	}
	//iterative way
	public int climbStairs (int A)
	{
		int ways[] = new int[A + 1];
	    
	    if (A == 1)
	        return 1;
	    ways[1] = 1;
	    ways[2] = 2;
	    
	    for (int i = 3; i <= A; i++) {
	        
	        ways[i] = ways[i - 1] + ways[i - 2];
	        
	        
	    }
	    
	}
}
