class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]

        Approach #1: bruteforce O((n-k)*k) = O(n^2)
        result = []
        * iterate i from 0 to n-kth element
            * result.append(max(result[i..i+k]))

        O(n)?
        Approach #2: DP solution
        dp[],nums[]
        * iterate i through 0..len(nums)-k


        [1,3,-1,-3, 5,3,6,7] k=3
         ^    ^                itialize dp[j] to -1
        [-1,-1,-1,-1,-1,-1,-1,-1]

        [1,3,-1,-3, 5,3,6,7] k=3
         ^    ^                if dp[1..j+k-1] is -1, set dp[j] to index of max(nums[j-1],nums[j])
        [-1,1,1,-1,-1,-1,-1,-1] result = [3]
                               result appends max(nums[dp[j+k-2]],nums[j+k-1])
                               dp[j+k-1] = index of max(nums[dp[j+k-2]],nums[j+k-1])
        [1,3,-1,-3, 5,3,6,7] k=3
           ^     ^              compare
        [-1,1,1, 2,-1,-1,-1,-1] result = [3,3]

        [1,3,-1,-3, 5,3,6,7] k=3
              ^     ^
        [-1,1,1, 2, 4,-1,-1,-1] result = [3,3,5]

        [1,3,-1,-3, 5,3,6,7] k=3
                 ^    ^
        [-1,1,1, 2, 4,4,-1,-1] result = [3,3,5,5]

        [1,3,-1,-3, 5,3,6,7] k=3
                    ^   ^
        [-1,1,1, 2, 4,4,6,-1] result = [3,3,5,5,6]

        [1,3,-1,-3, 5,3,6,7] k=3
                      ^   ^
        [-1,1,1, 2, 4,4,6,7] result = [3,3,5,5,6,7]

        """
        result = []
        n = len(nums)
        dp = [-1] * n
        if not(nums): return result
        # initialize the DP
        for i in range(1,k-1):
            dp[i] = i if nums[i-1] < nums[i] else  i-1

        for i in range(k-1,n):
            result.append(max(nums[dp[i-1]],nums[i]))
            dp[i] = i if nums[i-1] < nums[i] else  i-1
        return result
