"""
Given an array arr and a number n, you have to find whether there exist a subset in arr whose sum is n. You have to print length of the subset.
1. There exists only one subset like that
2. All number in arr are positive
"""

def find_subset(array,target):
    # check edge cases
    if not(array):
        return -1
    result = []
    find_subset_helper(0,array,[],result,target)
    return len(result) if len(result) > 0 else -1

"""
l = [1,3,4,15,8], target=4
4 - 1 = 3
"""
def find_subset_helper2(index,arr,target):
    # base cases
    if target == 0:
        return 1
    if target < 0:
        return -1
    for i in range(index,len(arr)):
        length = find_subset_helper2(i+1,arr,target-arr[i])
        if length >= 0:
            return length+1
    return -1

def find_subset_helper(index,arr,subset,result,target):
    # base cases
    total = sum(subset)
    #print(total)
    if total > target:
        return
    if total == target:
        result.extend(subset[:])
        return
    if index >= len(arr):
        return
    # back tracking logic
    if not(result):
        for i in range(index,len(arr)):
            subset.append(arr[i])
            find_subset_helper(i+1,arr,subset,result,target)
            subset.pop()

l = [1,3,4,15,8]
print(find_subset(l,4))
print(find_subset_helper2(0,l,4))
