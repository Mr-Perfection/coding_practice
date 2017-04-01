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

# better solution n log n. Sort the list and get the last 3 elements...
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        return nums[len(nums)-k]

class Solution(object):
    # O(n) time, quick selection
    def findKthLargest(self, nums, k):
        # convert the kth largest to smallest
        return self.findKthSmallest(nums, len(nums)+1-k)

    def findKthSmallest(self, nums, k):
        if nums:
            pos = self.partition(nums, 0, len(nums)-1)
            if k > pos+1:
                return self.findKthSmallest(nums[pos+1:], k-pos-1)
            elif k < pos+1:
                return self.findKthSmallest(nums[:pos], k)
            else:
                return nums[pos]

    # choose the right-most element as pivot
    def partition(self, nums, l, r):
        low = l
        while l < r:
            if nums[l] < nums[r]:
                nums[l], nums[low] = nums[low], nums[l]
                low += 1
            l += 1
        nums[low], nums[r] = nums[r], nums[low]
        return low
