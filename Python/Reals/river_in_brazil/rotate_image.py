class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if not(matrix): return
        n = len(matrix)
        for i in range(n):
            start,end = i,n-1-i
            for j in range(start,end):
                # set offset
                offset = j - start
                # top row element to temp. variable
                temp = matrix[start][start+offset]

                # left most col to top row
                matrix[start][start+offset] = matrix[end-offset][start]

                # bottom row to left most col
                matrix[end-offset][start] = matrix[end][end-offset]

                # right col to bottom row
                matrix[end][end-offset] = matrix[start+offset][end]
                # top row to right col
                matrix[start+offset][end] = temp
                
