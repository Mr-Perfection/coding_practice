class Solution(object):
    @classmethod
    def is_palindrome(cls,left,right):
        ls,rs = str(left),str(right)[::-1]
        if ls == rs: return True
        return False

    def largestPalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        # using greedy search algorithm
        if n == 1: return 9
        # if n = 3, max is 999 and min is 99
        m = 10**n
        mod = 1337
        celling = m - 1
        floor = int(m / 10)
        value = m * m
        left,right = int(value / m), value % m #998001 => left: 998, right:001
        if Solution.is_palindrome(left,right): return value % mod
        if left > right: left-=1
        value = left * m + int(str(left)[::-1])
        while left > floor:
            i = celling
            while i > value/i:
                if not(value % i): return int(value % mod)
                i-=1
            left -= 1
            value = left * m + int(str(left)[::-1])
        return value % mod







        
