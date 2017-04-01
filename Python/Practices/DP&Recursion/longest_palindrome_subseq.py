def helper(left,right,array,dp):
        # base case
        if left == right:
            return 1
        if left > right:
            return 0

        if dp[left][right] != -1: return dp[left][right]

        # check if array[left] and array[right] are same
        if array[left] == array[right]:
            dp[left][right] = 2 + helper(left+1,right-1,array,dp)
        else:
            dp[left][right] = max(helper(left,right-1,array,dp),helper(left+1,right,array,dp))
        return dp[left][right]

class Solution(object):
    def longestPalindromeSubseq(self, s):
        dp = [[-1 for j in range(len(s))] for i in range(len(s))]
        return helper(0,len(s)-1,list(s),dp)
