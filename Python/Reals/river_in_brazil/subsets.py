class Solution(object):
    def helper(self,A,index,lists,subset):
        # store subset into lists
        lists.append(subset[:])

        # base case
        if index >= len(A): return

        # iteration with backtracking
        for i in range(index,len(A)):
            subset.append(A[i])
            self.helper(A,i+1,lists,subset)
            subset.pop()

    def subsets(self, A):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        lists = []
        self.helper(A,0,lists,[])
        return lists
