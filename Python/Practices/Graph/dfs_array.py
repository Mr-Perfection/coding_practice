def find_path(row,col,grid,visited):
    # if row > grid length - 1 or col > grid[0] length - 1 or col < 0
    if not 0 <= row < len(grid) or not 0 <= col < len(grid[0])\
        or grid[row][col] == 0 or visited[row][col]:
        return 0
    visited[row][col] = True
    # if grid[row][col] == '1'
    if grid[row][col] == 1:
        #print(visited)
        # return  1+ max(find_path(row+1,col,grid),find_path(row,col-1,grid),find_path(row,col+1,grid),find_path(row-1,col,grid))
        #print(visited)
        result = 1 + find_path(row+1,col,grid,visited)\
                   + find_path(row,col+1,grid,visited)\
                   + find_path(row-1,col,grid,visited)\
                   + find_path(row,col-1,grid,visited)\
                   + find_path(row+1,col+1,grid,visited)\
                   + find_path(row-1,col-1,grid,visited)\
                   + find_path(row-1,col+1,grid,visited)\
                   + find_path(row+1,col-1,grid,visited)
        return result
    else:
        return 0
def getBiggestRegion(grid):
    result = 0
    mem = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
    # for i = 0...grid length - 1
    for i in range(len(grid)):
        # for j = 0...grid[0] length - 1
        for j in range(len(grid[0])):
            # max = max(max,find_path(i,j,grid))
                #print(result)
            result = max(result,find_path(i,j,grid,mem))
    # return max
    return result

n = int(input().strip())
m = int(input().strip())
grid = []
for grid_i in range(n):
    grid_t = list(map(int, input().strip().split(' ')))
    grid.append(grid_t)
print(getBiggestRegion(grid))
