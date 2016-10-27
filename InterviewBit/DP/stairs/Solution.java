public class Solution {
	public int climbStairs(int target) {
	    if (target == 0)
	        return (1);
	    else if (target < 0)
	        return (0);
	   return (climbStairs(target - 1) + climbStairs(target - 2));
	}
}
