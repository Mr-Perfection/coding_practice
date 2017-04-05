548. Split Array with Equal Sum

Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
Example:
Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5.
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1



class Solution(object):
    def splitArray(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        0 < i, i + 1 < j, j + 1 < k < n - 1
        Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
        
        ex) 
        [1,2,1,2,1,2,1]
        i=1,j=3,k=5
        
        """
        # edge case if len(nums) < 7, reutn false.
        # need to hav at least 7 elments
        if len(nums) < 7: return False
        
        
        sums = [0] * len(nums)
        sums[0] = nums[0]
        n = len(nums)
        # get sums from 1...n-1
        """
        ex) 
        given [1,2,1,2,1,2,1]
        sums [1,3,4,6,7,9,10]
        
        0 < i, i + 1 < j, j + 1 < k < n - 1
        0 < i, i < j - 1, j < k - 1 < n - 2
        """
        # initialize sums in increasing order
        for i in range(1,len(nums)):
            sums[i] = sums[i-1] + nums[i]
        
        # iterate from 3 (min half) to n - 4
        for j in range(3,n-3):
            valid = set()
            
            # iterate the left and put it in the set
            for i in range(1,j-1):
                if sums[i-1] == sums[j-1]-sums[i]:
                    valid.add(sums[i-1])
            
            # iterate the right and check if it is in the set
            for k in range(j+2,n-1):
                if sums[n-1] - sums[k] == sums[k-1] - sums[j] and sums[k-1]-sums[j] in valid:
                    return True
        return False
        
        
        # for i in range(1,len(nums)):
        #     sums[i] = nums[i] + sums[i-1]
        
        # for j in range(3,len(nums)-3):
        #     v = set()
        #     # 
        #     for i in range(1,j-1):
        #         if sums[i-1] == sums[j-1] - sums[i]: 
        #             v.add(sums[i-1])    
        #     for k in range(j+2,len(nums)-1):
        #         if sums[len(nums)-1] - sums[k] == sums[k-1] - sums[j] and sums[k-1]-sums[j] in v:
        #             return True
        # return False