class Solution(object):
    def threeSum(self, A):
        res = []
        n = len(A)
        A.sort()
        # iterate through the list
        for i in range(n-1):

            # left is i+1 and right is n-1
            left,right = i+1, n-1

            # skip the index if previous index is duplicate
            if i > 0 and A[i] == A[i-1]: continue

            # loop while left < right
            while left < right:

                # get the sum
                s = A[i]+A[left]+A[right]

                # if s is negative, increment left index
                if s < 0:
                    left += 1
                elif s > 0:
                    right -= 1
                else:
                    res.append([A[i],A[left],A[right]])
                    # skip the duplicates
                    while left < right and A[left] == A[left+1]:
                        left += 1
                    while left < right and A[right] == A[right-1]:
                        right -= 1
                    left += 1
                    right -= 1
        return res
