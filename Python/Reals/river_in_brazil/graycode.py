class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        res = [0]

        for i in range(n):
            res.extend([x + pow(2,i) for x in reversed(res)])

        return res

class Solution(object):
    def grayCode(self, n):
        if n == 0: return [0]
        if n == 1: return [0,1]
        # initializaitons
        result = [0]
        # loop i from 0...n-1
        for i in range(n):
            size = len(result)
            for j in range(size-1,-1,-1):
                result.append(result[j] | 1 << i)
        return result


        # def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        # if n == 0: return []
        # if n == 1: return [0,1]

        # bits = 1
        # result = [0,1]

        # # loop and shift left
        # for i in range(n-1):
        #     bits = bits << 1
        #     bits += 1
        #     result.append(bits)

        # # loop and make zerogs
        # for i in range(n-1):
        #     val = 2**i
        #     bits -= val
        #     result.append(bits)
        # return result
        # misunderstood the question
