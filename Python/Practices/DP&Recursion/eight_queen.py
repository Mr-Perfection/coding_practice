"""
Eight Queens: Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.


X-------
[0] = 0
--X-----
[1] = 2
----X---
------X-
---X----
-----X--
-------X
[6] = 7
-X------
[7] = 1
"""
import math

def check_diagonal(row,col,cols):
    for i in range(row):
        row_queen,col_queen = i,cols[i]
        # check if the col_queen is at the same column as col
        if col_queen == col:
            return False
        # check diagonals: if abs(col_queen-col) == abs(row_queen-row)
        # then false
        if abs(col_queen-col) == abs(row_queen-row):
            return False
    return True

"""
@param cols[8], an array of integers that contain the location of queen ex) cols[0]=2 => (0,2)
"""
def eight_queen_helper(row,cols,results):
    # base case: if row is equal to 8
    if row == 8:
        results.append(cols[:])
        return
    # iterate through all columns
    for j in range(8):
        # check diagonally
        if check_diagonal(row,j,cols):
            cols[row] = j
            eight_queen_helper(row+1,cols,results)



cols = [0 for i in range(8)]
results = []
eight_queen_helper(0,cols,results)
print(results)

for i in range(len(results)):
    for j in range(len(results[0])):
        row = list("xxxxxxxx")
        row[results[i][j]] = 'Q'
        print(''.join(row))
    print('\n')
