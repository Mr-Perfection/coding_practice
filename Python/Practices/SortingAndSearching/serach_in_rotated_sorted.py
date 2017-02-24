# 153. Find Minimum in Rotated Sorted Array
class Solution(object):
    global find_min_helper
    def find_min_helper(nums,left,right):
        # base case: if left >= right, return the first element
        if left >= right:
            return nums[0]
        # get middle element
        mid = (left+right)/2
        # check if mid < right and mid element > mid+1
        if mid < right and nums[mid] > nums[mid+1]:
            # return mid+1 element
            return nums[mid+1]
        # check if mid > left and mid element < mid-1 element
        if mid > left and nums[mid] < nums[mid-1]:
            return nums[mid]
        # check if mid < right and mid element < mid+1
        if nums[mid] < nums[right]:
            # return function(nums,mid+1,right)
            return find_min_helper(nums,left,mid-1)
        # return function(nums,left, mid)
        return find_min_helper(nums,mid+1,right)

    def findMin(self, nums):
        # if nums length is 1, return first element
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return min(nums)
        # return the helper function (log n) binary search
        return find_min_helper(nums,0,len(nums)-1)
