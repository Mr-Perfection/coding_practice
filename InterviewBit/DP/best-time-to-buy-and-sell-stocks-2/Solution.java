public class Solution {
	public int maxProfit(final List<Integer> a) {
	    
	    if (a == null || a.size() == 0)
	        return (0);
	    int dp[] = new int[a.size()];
	    dp[0] = 0;
	    for (int i = 1; i < a.size(); ++i)
	    {
	        if (a.get(i) - a.get(i - 1) >= 0)
	            dp[i] = dp[i - 1] + a.get(i) - a.get(i - 1);
	        else
	            dp[i] = dp[i - 1];
	    }
	    return (dp[a.size() - 1]);
	}
}
