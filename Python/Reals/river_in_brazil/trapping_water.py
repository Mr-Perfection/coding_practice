class Solution(object):
    def trap(self, A):
        """
        :type height: List[int]
        :rtype: int
        """
        if not(A): return 0
        i = 0
        cnt = 0
        left = [0 for i in range(len(A))]
        right = [0 for i in range(len(A))]
        left[0] = A[0]
        right[len(A)-1] = A[len(A)-1]
        # get the max heights from left side
        for i in range(1,len(A)):
            left[i] = max(left[i-1],A[i])
        # get the max heights from right side
        for i in range(len(A)-2,-1,-1):
            right[i] = max(right[i+1],A[i])
        # get the min(left[i],right[i]) - A[i]
        for i in range(len(A)):
            v = min(left[i],right[i])-A[i]
            if v > 0:
                cnt += v
        return cnt



class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # approach #1: track max from left and right O(n^2)
        """
            * set left index if height[i+1] >= height[i] else exit
            * do same but set right index if height[i-1] >= height[i] else exit
            * max = left
            * loop i from left+1 to right
                * if height[max] <= height[i]
                    * for j from max to i-1
                        * rain += (height[max] - height[j])
                    * set max = i
            * do same from right-1 to left...
        # approach #2: store max values from left and right
            left[height[0]],right[height[n-1]]
            for i from 1 to len(height)-1
                if left[i-1] < height[i]
                    left[i] = height[i]
                else
                    left[i] = left[i-1]
            for i from len(height)-2 to 0
                if right[i+1] < height[i]
                    right[i] = height[i]
                else
                    right[i] = right[i+1]
            water = 0
            for i from 0 to len(height)-1
                val = min(right[i],left[i]) - height[i]
                if val > 0
                    rains += val
            return rains


        """
