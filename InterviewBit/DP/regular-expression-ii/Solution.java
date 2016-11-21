public class Solution {
	/***
	isMatch("aa","a") → 0
	isMatch("aa","aa") → 1
	isMatch("aaa","aa") → 0
	isMatch("aa", "a*") → 1
	isMatch("aa", ".*") → 1
	isMatch("ab", ".*") → 1
	isMatch("aab", "c*a*b") → 1
	
	aa
	a
	[1 1] => 1 < len = 2, return 0
	aa
	aa
	[1 2] => 1 = len = 2, return 1
	aaa
	aa
	[1 2 ] the element does not exist in p return 0
	aaa
	a*
	[1 2 3] => 3 = len = 3, the element is * if nothing exists after, then return 1.
	**/
	public int isMatch(final String s, final String p) {

		int m = s.length(), n = p.length();
		int i, j;
		int[][] dp = new int[m + 1][n + 1];
		dp[0][0] = 1;

		//for the patterns like: a*, a*b*
		for(j = 1; j < n; ++j)
		{
			if (p.charAt(j - 1) == '*')
			{
				dp[0][j] = dp[0][j - 2];
			}

		}
/*
A : "efwihfioghih35i"
B : ".*"
does not work.
should return 1.

*/
		for (i = 1; i < dp.length; ++i)
		{
			for(j = 1; j < dp[0].length; ++j)
			{
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
				{
					dp[i][j] = dp[i - 1][j - 1];
				}
				else if (p.charAt(j - 1) == '*')
				{
					dp[i][j] = dp[i][j - 2];
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
						dp[i][j] = dp[i][j] | dp[i - 1][j];
					
				}
				else
					dp[i][j] = 0;
			}
		}
		return (dp[m][n]);
	}
}
