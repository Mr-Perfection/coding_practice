"""
Magic Index: A magic index in an array A[1. .. n-1] is defined to be an index such that A[i] = i
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.

can integer be negative?
    I assumed that integer can be negative,0,and positive.
Is there only one magic index?
    I assumed there is only one.

sorted array of distinct integer, A = [-2,0,2,4,5,6]
                                            ^ magic!
FOLLOW UP
What if the values are not distinct?
"""

"""
Bruteforce
"""
def magic_index(A):
    for i in range(len(A)):
        if A[i] == i:
            return i
    return -1
"""
T: O(n)
S: O(1)
"""
"""
Binary search
"""
def magic_index2(A):
    return magic_search(A,0,len(A))

def magic_search(A,left,right):
    # check if left < 0 or right >= length of A
    if left >= right:
        return -1
    mid = int((left + right) / 2)
    # if A[mid] < mid, the magic index is on the right side.
    # recurse to the right
    if A[mid] < mid:
        return magic_search(A,mid,right)
    # if A[mid] > mid, the magic index should be on the left side
    # recurse to the left
    if A[mid] > mid:
        return magic_search(A,left,mid)
    #if none of these conditions are true, this is the answer
    return mid
"""
T: O(log n)
S: O(log n)
"""


"""
FOLLOW UP
What if the values are not distinct?

Distinct but sorted
 0   1 2 3 4 5 6 7 8 9  10
[-1,-1,1,1,2,2,8,8,8,12,12]

mid = 10 - 0 /2 = 5
mid  > A[mid], go right

"""

def magic_index_follow_up(A):
    return magic_search_follow_up(A,0,len(A))

def magic_search_follow_up(A,left,right):
    # base case: if left >= right, return -1
    if left >= right:
        return -1
    # get mid index
    mid = int((left + right) / 2)
    # if mid index  > A[mid], go to right.
    if mid > A[mid]:
        # new left becomes max(mid+1,A[mid])
        return magic_search_follow_up(A,max(mid+1,A[mid]),right)
    # if mid index  < A[mid], go to left
    elif mid < A[mid]:
        # new right becomes min(mid-1,A[mid]).
        return magic_search_follow_up(A,left,min(mid-1,A[mid]))
    # return mid index
    return mid


A = [-40,-21,-1,1,2,3,4,5,8,12,13]
A = [-1,-1,1,1,2,2,8,8,8,12,12]

print(magic_index(A))
print(magic_index2(A))
print(magic_index_follow_up(A))
