public class Solution {
	public int isMatch(final String s, final String p) {
	    
	    int rows = s.length() + 1;
	    int cols = p.length() + 1;
	    int[][] dp = new int[rows][cols];
	    
	    Arrays.fill(dp[0], 0);
	    for (int i = 0; i < rows; ++i)
	        dp[i][0] = 0;
	    // p[0.., j - 3, j - 2, j - 1] matches empty iff p[j - 1] is '*' and p[0..j - 3] matches empty
        for (int i = 1; i <= p.length(); i++)
        {
            if ( i > 1 && '*' == p.charAt(i - 1) && dp[0][i - 2] == 1)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }
            
	    dp[0][0] = 1;
	    for (int i = 1; i < rows; ++i)
	    {
	        for (int j = 1; j < cols; ++j)
	        {
	           // if (p.charAt(j - 1) != '*')
	           //     dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1)) || '?' == p.charAt(j - 1);
	           // else
	           //     dp[i][j] = dp[i - 1][j] | dp[i][j - 1] | dp[i - 1][j - 1];
	            //case 1: two chars are equal to each other
	            if (s.charAt(i - 1) == p.charAt(j - 1))
	                dp[i][j] = dp[i - 1][j - 1];
	            else if (p.charAt(j - 1) == '?')
	                dp[i][j] = dp[i - 1][j - 1];
	            else if (p.charAt(j - 1) == '*')
	                dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
	            else
	                dp[i][j] = 0;
	        }
	    }
	    return dp[rows - 1][cols - 1];
	}
}



public int isMatch(final String s, final String p) {

    if (s == null || p == null) {
        return 0;
    }
    int[][] dp = new int[s.length()+1][p.length()+1];
    dp[0][0] = 1;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1] == 1) {
            dp[0][i+1] = 1;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] | dp[i][j+1] | dp[i+1][j-1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}







//my solution almost working without one edge case "*********" etc.

public class Solution {
	public int isMatch(final String s, final String p) {
	    
	    int rows = s.length() + 1;
	    int cols = p.length() + 1;
	    int[][] dp = new int[rows][cols];
	    
	    //https://www.youtube.com/watch?v=3ZDZ-N0EPV0
	    //get rid of duplicates of * here.
	    
	    Arrays.fill(dp[0], 0);
	    if (p.charAt(0) == '*' && p.length() == 1)
	        return (1);
	        
	    for (int i = 0; i < rows; ++i)
	        dp[i][0] = 0;
	        
	   
	    dp[0][0] = 1;
	    for (int i = 1; i < rows; ++i)
	    {
	        for (int j = 1; j < cols; ++j)
	        {
	           // if (p.charAt(j - 1) != '*')
	           //     dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1)) || '?' == p.charAt(j - 1);
	           // else
	           //     dp[i][j] = dp[i - 1][j] | dp[i][j - 1] | dp[i - 1][j - 1];
	            //case 1: two chars are equal to each other
	            if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
	                dp[i][j] = dp[i - 1][j - 1];
	            else if (p.charAt(j - 1) == '*')
	                dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
	            else
	                dp[i][j] = 0;
	        }
	    }
	    return dp[rows - 1][cols - 1];
	}
}
