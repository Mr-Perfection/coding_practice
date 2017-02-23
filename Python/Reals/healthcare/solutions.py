# given arra a of n distinct positive integers,


"""
subarray a[i..j] contains elements a[i],


"""

# I will be using backtracking
# O(2^n^2)
def beautiful_subarray_helper(array,solution,target,subarray,index):
    # if subarray is not empty
    if len(subarray) != 0:
        odds = 0
        # iterate through subarray
        for x in subarray:
            # count odd numbers
            if x % 2 != 0:
                odds += 1
        # check if this subarray contains target number of odds
        if odds == target:
            s,temp = ''.join(map(str,array)), subarray[:]
            test = ''.join(map(str,temp))
            if test in s:
                solution.append(subarray[:])
    # base case: check if index is out of bound
    if index >= len(array):
        return
    # iterate i from index to array length
    for i in range(index,len(array)):
        # always pass in index+1
        subarray.append(array[i])
        beautiful_subarray_helper(array,solution,target,subarray,i+1)
        subarray.pop()

def  beautifulSubarrays(array, target):
    if not(array) or target < 0:
        return 0
    # initialization
    solution,sub = [],[]
    # use helper to aggregate all the possible subarrays with target number of odds
    beautiful_subarray_helper(array,solution,target,sub,0)
    return len(solution)





# use dynamic programming (memoization)
# O(n)
def can_reach_helper(x1,y1,end,memo):
    # base case: if start becomes end return True
    if x1 == end[0] and y1 == end[1]:
        return 1
    # base case: if start[0] > end[0] or start[1] > end[1], return False
    if x1 > end[0] or y1 > end[1]:
        return 0
    # if memo is not -1, return memo[][]
    if memo[x1][y1] != -1:
        return memo[x1][y1]
    # recurse two ways: 1) + 2)
    memo[x1][y1] = can_reach_helper(x1 + y1, y1, end,memo) or can_reach_helper(x1, y1+x1, end,memo)
    return memo[x1][y1]


def  canReach(x1, y1, x2, y2):
    """
    x2 and y2 are the target
    Two ways:
        1) x1+y1,y1 or 2) x1,y1+x1
    """
    memo = [[-1 for y in range(0,y2+1)] for x in range(0,x2+1)]
    # call helper method
    return 'Yes' if can_reach_helper(x1,y1,[x2,y2],memo) == 1 else 'No'




def can_reach_helper(x2,y2,end,memo):
    # base case: if end becomes end return True
    if x2 == end[0] and y2 == end[1]:
        return 1
    # base case: if end[0] > end[0] or end[1] > end[1], return False
    if x2 < end[0] or y2 < end[1]:
        return 0
    # if memo is not -1, return memo[][]
    if memo[x2][y2] != -1:
        return memo[x2][y2]
    # recurse two ways: 1) + 2)
    memo[x2][y2] = can_reach_helper(x2 - end[1], y2, end,memo) or can_reach_helper(x2, y2 - end[0], end,memo)
    return memo[x2][y2]

def  canReach(x1, y1, x2, y2):
    """
    x2 and y2 are the target
    Two ways:
        1) x1+y1,y1 or 2) x1,y1+x1
    """
    memo = [[-1 for y in range(0,y2+1)] for x in range(0,x2+1)]
    # call helper method
    return 'Yes' if can_reach_helper(x2,y2,[x1,y1],memo) == 1 else 'No'
