'''
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
'''

class Solution(object):
    def helper(self, row, col, mem):
        m,n = len(mem), len(mem[0])

        if row == m or col == n:
            return 0

        if row == m-1 and col == n-1:
            return 1

        if mem[row][col] != -1: return mem[row][col]
        mem[row][col] = self.helper(row+1,col,mem) + self.helper(row,col+1,mem)
        return mem[row][col]

    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        mem = [[-1 for j in range(n)] for i in range(m)]
        return self.helper(0,0,mem)

'''
follow-up
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
'''
class Solution(object):
    def helper(self, row, col, grid, mem):
        m,n = len(mem), len(mem[0])

        if row == m or col == n or grid[row][col] == 1:
            return 0

        if row == m-1 and col == n-1:
            return 1

        if mem[row][col] != -1: return mem[row][col]
        mem[row][col] = self.helper(row+1,col,grid, mem) + self.helper(row,col+1,grid,mem)
        return mem[row][col]
    def uniquePathsWithObstacles(self, grid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m,n = len(grid), len(grid[0])
        mem = [[-1 for j in range(n)] for i in range(m)]
        return self.helper(0,0,grid, mem)

        
