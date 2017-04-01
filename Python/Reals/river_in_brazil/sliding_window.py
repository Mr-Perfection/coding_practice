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
        Approach #2: Using Queue
        1  3  -1 -3  5  3  6  7   k=3
        [0]
        1  3  -1 -3  5  3  6  7   k=3
        [1]
        1  3  -1 -3  5  3  6  7   k=3
               ^
        [1,2]
        result = [3]
        1  3  -1 -3  5  3  6  7   k=3
                  ^
        [1,2,3]
        result = [3,3]

        1  3  -1 -3  5  3  6  7   k=3
                     ^
        [2,5]
        result = [3,3,-1]

        * iteraete through nums with index and value (enumerate)
        * if queue is not empty and queue[0] is not in the window (<=i-k)
        * then remove first element
        * if last element in queue and if it is less than current value
        * then pop queue
        * add index to queue
        * if i+1 >= k
        * then append nums[queue[0]] to result
        ...
        """
        result = []
        queue = []
        n = len(nums)
        for i,v in enumerate(nums):
            # remove the outdated index (<= i-k) in queue
            if queue and queue[0] <= i-k:
                queue = queue[1:]
            #
            while queue and nums[queue[-1]] < v:
                queue.pop()
            queue.append(i)
            if i+1 >= k:
                result.append(nums[queue[0]])
        return result
