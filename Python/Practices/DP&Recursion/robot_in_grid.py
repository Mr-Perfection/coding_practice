"""
Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them.
Design an algorithm to find a path for the robot from the top left to the bottom right.

[rows][columns]

what does it mean by "off limits"? Do they mean like obstacles?

I assumed that grid is given with obstacles (integer 2D array filled with 1s and 0s. 0s mean off limits which robot cannot step on.)
There are two possible moves: rows + 1 (down), columns + 1 (right)
I assumed that we are returning a list of indexes (row,col)
return [(row,col)]
"""
import time

def robot_in_grid(grid):
    rows = len(grid)
    columns = len(grid[0])
    result = []
    if robot_in_grid_helper(grid,len(grid)-1,len(grid[0])-1,result):
        return result
    else:
        return list()

def robot_in_grid_helper(grid,r,c,result):
    #base case: if rows and columns are negative, return False
    if r < 0 or c < 0:
        return False
    # if current r and c element is -1, return False
    if grid[r][c] == -1:
        return False
    print(r,c,"first")
    # recurse r-1 or c-1 th element of the grid and check if they are true
    if (r == 0 and c == 0) or robot_in_grid_helper(grid,r-1,c,result) or robot_in_grid_helper(grid,r,c-1,result):
        # if they are true, add it to result and return true
        result.append((r,c))
        return True
    # return false at the end
    return False



# using DP
def robot_in_grid_dp(grid):
    rows = len(grid)
    columns = len(grid[0])
    dp = [[True for col in range(columns)] for row in range(rows)]
    result = []
    dp2 = set()
    if robot_in_grid_helper_dp(grid,len(grid)-1,len(grid[0])-1,dp2,result):
        return result
    else:
        return list()

def robot_in_grid_helper_dp(grid,r,c,dp,result):
    #base case: if rows and columns are negative, return False
    if r < 0 or c < 0:
        return False
    # if current r and c element is -1, return False
    if grid[r][c] != 0:
        #dp[r][c] = False
        return False
    #print(r,c,dp)
    if (r,c) in dp:
        return False
    #if dp[r][c] == False:
    #    return False
    # recurse r-1 or c-1 th element of the grid and check if they are true
    if (r == 0 and c == 0) or robot_in_grid_helper_dp(grid,r-1,c,dp,result) or robot_in_grid_helper_dp(grid,r,c-1,dp,result):
        # if they are true, add it to result and return true
        result.append((r,c))
        return True
    # return false at the end
    print(r,c,dp)
    dp.add((r,c))
    #dp[r][c] = False
    return False


# DP solution... should take O(r*c) but it is not working...

grid = [[0,0,0],[-1,0,-1],[0,0,0],[0,-1,0],[0,0,0],[0,-1,0],[0,-1,0],[0,-1,0],[0,-1,0]]
start_time = time.time()
print(robot_in_grid(grid))
print("--- %s seconds ---" % (time.time() - start_time))
start_time = time.time()
print(robot_in_grid_dp(grid))
print("--- %s seconds ---" % (time.time() - start_time))
