"""
Sorted Search, No Size: You are given an array-like data structure Listy which lacks a size method.It does, however, have an elementAt(i) method that returns the element at index i in 0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data structure only supports positive integers.) Given a Listy which contains sorted, positive integers, find the index at which an element x occurs. If x occurs multiple times, you may return any index.



Given: "listy" data structure (array w/ values and -1) and element x

listy = [0,3,4,4,5,5,5,5,8,9,-1,-1], x = 4
Assumptions:
    - when x occurs more than 1x, return index

Binary search (modified?):
    [0,3,4,4,5,5,5,5,8,9,-1,-1]
                 ^   4 < 5 go left
    [0,3,4,4,5,5,5,5,8,9,-1,-1]
           ^   4 == 4 check left or right. If true, return index. else -1
               if el is -1, return -1
"""

# time: log(n), space: O(log(n))
# recusive
def sorted_search(listy,x,left,right):
    # if listy is  None return -1
    if not(listy) or len(listy) == 0:
        return -1
    # base case: if left exceeds right, return -1
    if left >= right:
        return -1
    # get middle index
    mid = int((left+right) / 2)
    # base case 2: if the element is -1, return -1
    if listy[mid] == -1:
        return -1
    # if middle element is equal to x, check middle-1 or middle+1 values
    if listy[mid] == x:
        # if any of those values are equal to middle element
        if mid-1 >= 0 and listy[mid-1] == x:
            return mid
        if mid+1 < len(listy) and listy[mid-1] == x:
            return mid
        return -1
    # if middle is greater than x, move left
    if listy[mid] > x:
        return sorted_search(listy,x,left,mid)
    # if middle is less than x, move right
    if listy[mid] < x:
        return sorted_search(listy,x,mid,right)
# iterattive space becomes O(1)
# time: log(n), space: O(1)

def sorted_search(listy,x,left,right):
    # if listy is  None return -1
    if not(listy) or len(listy) == 0:
        return -1
    while left < right:
        mid = int((left+right) / 2)
        # base case 2: if the element is -1, return -1
        if listy[mid] == -1:
            return -1
        # if middle element is equal to x, check middle-1 or middle+1 values
        if listy[mid] == x:
            # if any of those values are equal to middle element
            if mid-1 >= 0 and listy[mid-1] == x:
                return mid
            if mid+1 < len(listy) and listy[mid-1] == x:
                return mid
            return -1
        # if middle is greater than x, move left
        if listy[mid] > x:
            right = mid
        # if middle is less than x, move right
        if listy[mid] < x:
            left = mid
    return -1

listy = [0,3,4,4,5,5,5,5,8,9,-1,-1]
x = 5
print(sorted_search(listy,x,0,len(listy)))
