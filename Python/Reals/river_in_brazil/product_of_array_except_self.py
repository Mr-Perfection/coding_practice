class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [0] * len(nums)
        total = 1
        zeros = 0
        zpos = 0

        for i in range(len(nums)):
            if not(nums[i]):
                zeros += 1
                zpos = i
            else:
                total *= nums[i]

        if zeros > 1: return [0] * len(nums)
        if zpos:
            res[zpos] = total
            return res

        n = len(nums) - 1
        while n >= 0:
            res[n] = total / nums[n]
            n -= 1

        return res
