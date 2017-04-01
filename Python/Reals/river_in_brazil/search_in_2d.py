class Solution(object):


    # O(m+n)
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not(matrix) or len(matrix) < 1 or len(matrix[0]) < 1:
            return False

        n,m = len(matrix)-1,0
        while n >= 0 and m < len(matrix[0]):
            if matrix[n][m] == target: return True
            if matrix[n][m] > target:
                n -= 1
            else:
                m += 1

        return False


# O(mlogn)
class Solution(object):
def binary_search(self,arr,left,right,target):
    while left <= right:
        mid = (left+right) / 2
        if arr[mid] == target: return True
        elif arr[mid] < target:
            left = mid+1
        elif arr[mid] > target:
            right = mid-1

def searchMatrix(self, matrix, target):
    """
    :type matrix: List[List[int]]
    :type target: int
    :rtype: bool
    """
    if not(matrix) or len(matrix) < 1 or len(matrix[0]) < 1:
        return False
    if len(matrix[0]) == 1 and len(matrix) == 1:
        if matrix[0][0] == target: return True
    for i in range(len(matrix)):
        if self.binary_search(matrix[i],0,len(matrix[i])-1,target): return True

    return False
