"""
Find the longest path in a matrix with given constraints
Given a n*n matrix where numbers all numbers are distinct and are distributed from range 1 to n2,
find the maximum length path (starting from any cell) such that all cells along the path are increasing order with a difference of 1.

We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1)
with the condition that the adjacen

Example:

Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9.

move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1)
                    1
                2       1 2,i+1
            9       2 9        1 2 9,i+1
                return 0    2 3 return 2    1 2 3,j-1 return 3
        5..
"""

import time

def longest_path(mat,i,j):
    if i > len(mat)-1 or j > len(mat[0])-1 or i<0 or j<0:
        return 0


    # right
    if  j < len(mat[0])-1 and mat[i][j+1]-mat[i][j] == 1:
        return 1+longest_path(mat,i,j+1)
    # left
    if  j > 0 and mat[i][j-1]-mat[i][j] == 1:
        return 1+longest_path(mat,i,j-1)
    # bottom
    if  i > 0 and mat[i-1][j]-mat[i][j] == 1:
        return 1+longest_path(mat,i-1,j)
    # top
    if  i < len(mat)-1 and mat[i+1][j]-mat[i][j] == 1:
        return 1+longest_path(mat,i+1,j)

    return 1

# go through all the possible cases
def longest_path_mem(mat,i,j,mem):
    if i > len(mat)-1 or j > len(mat[0])-1 or i<0 or j<0:
        return 0

    if mem[i][j] > -1:
        return mem[i][j]
    if mem[i][j]==-1:
        mem[i][j] = 1
    # right
    if  j < len(mat[0])-1 and mat[i][j+1]-mat[i][j] == 1:
        mem[i][j] = max(mem[i][j],1+longest_path_mem(mat,i,j+1,mem))
    # left
    if  j > 0 and mat[i][j-1]-mat[i][j] == 1:
        mem[i][j] = max(mem[i][j],1+longest_path_mem(mat,i,j-1,mem))
    # bottom
    if  i > 0 and mat[i-1][j]-mat[i][j] == 1:
        mem[i][j] = max(mem[i][j],1+longest_path_mem(mat,i-1,j,mem))
    # top
    if  i < len(mat)-1 and mat[i+1][j]-mat[i][j] == 1:
        mem[i][j] = max(mem[i][j],1+longest_path_mem(mat,i+1,j,mem))

    return mem[i][j]

# time
# Driver program to test the functions above
def main():
    n = 3
    m = [[1,2,9],[5,3,8],[4,6,7]]
    #print(m)
    start_time = time.time()
    result = 1
    mem = [[-1 for j in range(len(m))] for i in range(len(m))]
    for i in range(len(m)):
        for j in range(len(m)):
            result = max(result,longest_path_mem(m,i,j,mem))
    print(result)
    print("--- %s seconds ---" % (time.time() - start_time))
    #start_time = time.time()
    #print(distance_m(n,m))
    #print("--- %s seconds ---" % (time.time() - start_time))

if __name__=="__main__":
    main()
