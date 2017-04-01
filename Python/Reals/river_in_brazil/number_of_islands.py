class Solution(object):

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # edge case
        if not(grid): return 0

        cnt = 0
        n = len(grid)
        if n == 0: return 0
        m = len(grid[0])

        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1':
                    self.visited(grid,i,j,n,m)
                    cnt += 1
        return cnt

    def visited(self, grid, row, col,n,m):
        if row < 0 or col < 0 or row >= n or col >= m\
           or grid[row][col] != '1':
            return
        grid[row][col] = '0'
        self.visited(grid,row+1,col,n,m)
        self.visited(grid,row,col+1,n,m)
        self.visited(grid,row-1,col,n,m)
        self.visited(grid,row,col-1,n,m)
