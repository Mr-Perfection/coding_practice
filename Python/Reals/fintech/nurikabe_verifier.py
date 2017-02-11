"""
types:
'.' = water
'#' = island
'1' or other number = number square

rules:
squares are connected up,down,right,and left
island sqaure can only have one numbered square
numbered squre can contain itself + island square(s) ex) '2' means itself + 1 island

My thought process:
check 2x2 block of water ex) [i+1][j],[i][j],[i][j+1],[i+1][j+1]
check other characters that are NOT '1-9', '.', '#'
check numbered square and if it is > 1, follow the logic below:
    set n = [i][j]-1
    if n is 1, then check only [i-1][j],[i+1][j],[i][j-1],[i][j+1]
    if n is odd, then check only [i-x][j],[i+x][j],[i][j-x],[i][j+x], x= 0<x<=n
    ...


"""


"""
Only have 8 minutes left
running out of time for this function, so I would like to explain what it will do once finished.

check_not_valid_number_square:
    return False if numbered square is 1 (this means valid because we want to find one that does not have enough islands)
    set n = number-1

    start the counter that will sum all the islands within 1..n and diagonally 1..n-1
    if counter < n
        return True
"""
def check_not_valid_number_square(puzzle,i,j,islands):
    n = int(puzzle[i][j])-1

    if n == 0:
        return False
    cnt = 0
    for k in range(1,n+1):
        if j-k >= 0 and puzzle[i][j-k] == '#':
            if islands[i][j] == False:
                islands[i][j] = True
                cnt += 1
            if cnt == n:
                return False
        if j+k < len(puzzle[0]) and puzzle[i][j+k] == '#':
            if islands[i][j] == False:
                islands[i][j] = True
                cnt += 1
    if cnt < n:
        return True
    return False

def check_illegal_char(value):
    if value.isdigit() or value == '.' or value == '#':
        return True
    return False

def check_not_water_block(puzzle,i,j):
    # check itself,right,diagonal,bottom
    if puzzle[i][j] == '.':
        # verify if i is not the last row and j is not the right-most row
        if i < len(puzzle)-1 and j < len(puzzle[0])-1:
            if puzzle[i+1][j] == '.' and puzzle[i][j+1] == '.' and puzzle[i+1][j+1] == '.':
                return False
    return True

def verify(puzzle):
    islands = list(list(False for j in range(len(puzzle[0]))) for i in range(len(puzzle)))
    print(islands)

    for i in range(len(puzzle)):
        for j in range(len(puzzle[0])):
            # 1. check illegal values other than '1-9', '.', '#'
            if(check_illegal_char(puzzle[i][j])):
                # 2. check if there exists 2x2 water
                if(check_not_water_block(puzzle,i,j)):
                    print(i,j)
                    # 3. check if the square can reach and contain the island. Set island to True if number square has reached it.
                    #if puzzle[i][j].isdigit():
                        #if(check_not_valid_number_square(puzzle,i,j,islands)):
                            #return False
                else:
                    return False
            else:
                return False
    return True

# passed 5/9 test cases...
