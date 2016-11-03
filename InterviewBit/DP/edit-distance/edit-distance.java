public class Solution {
	public static int find_min(int a, int b, int c)
	{
		int x = (a < b) ? a : b;
		return ((x < c) ? x : c);
	}
	public int minDistance(String str1, String str2) {
	    
	    int cnt = 0; //count how many elements to be deleted
	    int i ,j;
	    
	    if (str1 == null || str2 == null)
	        return (0);
	    int dp[][] = new int[str1.length() + 1][str2.length() + 1];
	    //initialize the first row.
	    for (i = 0; i <= str1.length(); ++i)
	        dp[i][0] = i;
	    //initialize the first column.
	    for (j = 0; j <= str2.length(); ++j)
	        dp[0][j] = j;
	   	//traverse through the entire dp array.
	    for (i = 1; i <= str1.length(); ++i)
	    {
	    	for (j = 1; j <= str2.length(); ++j)
	    	{
	    		//if s1[i] matches with s2[j] then get the previous result.
	    		if (str1.charAt(i - 1) == str2.charAt(j - 1))
	    			dp[i][j] = dp[i - 1][j - 1];
	    		else
	    			//get the minimum of three possible ways: delete(get the previous ith element and + 1), insert(get the previous jth element and + 1), and 
	    			// replace (get the previous ith and jth element and  + 1.
	    			dp[i][j] = find_min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
	    	}
	        
	    }
	    return (dp[str1.length()][str2.length()]);
	    
	}
}
