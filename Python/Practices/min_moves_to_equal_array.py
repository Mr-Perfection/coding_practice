class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
        increments all elements except one = decrements one element
        [1,2,3]
        *find the minimum value of an array
        1
        *subtract all elements by 1
        [0,1,2]
        *add all the values into one value
        0+1+2=3
        return 3

        """
        min_value = min(nums)
        values = [a-min_value for a in nums]
        return sum(values)
