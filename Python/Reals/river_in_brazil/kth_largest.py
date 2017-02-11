'''
Question: Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.

For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements i.e., k = 3 then your program should print 50, 30 and 23.
'''

"""
input: [1, 23, 12, 9, 30, 2, 50]



output: 50 30 23
"""

def kth_largest(arr,k):
    index = 0
    MAX_VALUE = arr[0]
    solution = set()
    for i in range(k):
        MAX_VALUE = arr[0]
        for j in range(len(arr)):
            if arr[j] not in solution and arr[j] >= MAX_VALUE:
                index = j
                MAX_VALUE = arr[index]
        solution.add(arr[index])
    return solution
# Time: O(k * n)
# Space: O(k)

inputs = [1, 23, 12, 9, 30, 2, 50]
k = 3

print(kth_largest(inputs,k))
