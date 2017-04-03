import sys

class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        7
        [2,3,1,2,4,3]
        2+3+1+2
        3+1+2+4
        1+2+4
        i = 3
        total = 8
        smallest = 3
        total = 6
        i = 4
        total = 10
        smallest = 4-1
        total = 7
        j = 2

        """
        # edge case
        if not(nums): return 0

        # initializations
        smallest = sys.maxint
        i,j = 0,0
        n = len(nums)
        total = 0
        # get the total
        for i in range(n):
            total += nums[i]
            # if total gets greater than s
            # keep track of diff in i and j
            # remove the first value
            while total >= s:
                smallest = min(smallest, i - j + 1)
                total -= nums[j]
                j += 1
        return 0 if smallest == sys.maxint else smallest
