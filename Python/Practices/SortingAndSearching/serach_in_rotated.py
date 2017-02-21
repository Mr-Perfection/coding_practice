
"""
Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown number of times,
write code to find an element in the array. You may assume that the array was originally sorted in increasing order.

is the rotation clockwise??
I assumed it is.

[1,2,3,4,5]
rotated n number of times...
[3,4,5,1,2]

[4,5,1,2,3] check mid -1 and mid + 1 value

O(n) approach:
iterate through the entire array and find the match

O(log n) approach:
binary search?

"""
# O(log n) approach
def search_in_rotated(a,left,right,value):
    # check if a is blank or left exceeds right
    if left >= right or len(a) == 0:
        return -1
    # check the middle is the answer
    mid = int((left + right) / 2)
    if a[mid] == value:
        return mid
    # recurse through left and right
    return max(search_in_rotated(a,left,mid,value), search_in_rotated(a,mid+1,right,value))

a = [2, 2, 2, 3, 4, 2]
val = 3
print(search_in_rotated(a,0,len(a),val))
