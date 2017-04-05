Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.



class Solution(object):

    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        try to visualize the multiplication
        awesome explanation
        https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
        """
        if num1 == '0' or num2 == '0': return '0'
        m,n = len(num1), len(num2)
        A = [0] * (m+n)
        res = []
        # iterate through num1 and num2 as i and j
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                p1,p2 = i+j, i+j+1
                # multiplication of num1[i] & num[j]
                mult = int(num1[i]) * int(num2[j])
                # add it to current value that A[p2] has.
                s = A[p2] + mult
                # add it to the next. A[p1]
                A[p1] += s / 10
                # update the p2 element
                A[p2] = s % 10
        while len(A) > 0 and A[0] == 0:
            A.pop(0)
        res = map(lambda x: str(x),A)
        return ''.join(res)


        
