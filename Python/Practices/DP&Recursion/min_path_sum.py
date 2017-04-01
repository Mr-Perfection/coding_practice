import sys

class Solution(object):
    @classmethod
    def helper(cls,grid,row,col,dst,dp):
        if row > dst[0] or col > dst[1]: return sys.maxint

        if dp[row][col] != -1:
            return dp[row][col]

        if row == dst[0] and col == dst[1]:
            return grid[dst[0]][dst[1]]

        dp[row][col] = grid[row][col] + min(Solution.helper(grid,row+1,col,dst,dp),Solution.helper(grid,row,col+1,dst,dp))
        return dp[row][col]
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row,col = 0,0
        dst = [len(grid)-1,len(grid[0])-1]
        dp = [[-1 for j in range(dst[1]+1)] for i in range(dst[0]+1)]
        return Solution.helper(grid,row,col,dst,dp)

        
