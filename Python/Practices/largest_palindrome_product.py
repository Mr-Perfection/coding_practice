"""
479. Largest Palindrome Product

Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.

Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

Note:

The range of n is [1,8].
"""
class Solution(object):
    def largestPalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        d1 = d2 = int([9]*n)


class Solution(object):

    def largestPalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        lst = ['9']*n
        #print(''.join(lst))
        d1 = d2 = int(''.join(lst))
        results = []
        flag = False
        def is_palindrome(n):
            s = str(n)
            for i in range(len(s)/2):
                if s[i] != s[len(s)-1-i]:
                    return False
            return True
        print(d1,d2)
        while d2 > 0:
            #print(d1*d2)
            if is_palindrome(d1*d2):
                #print(d1,d2)
                results.append(d1*d2)
                break
            d2-=1
        print(d1,d2)
        d2 = d1
        print(d1,d2)
        while d2 > 0:
            if is_palindrome(d1*d2):
                results.append(d1*d2)
                break
            if flag == False:
                d2-=1
                flag = True
            else:
                d1-=1
                flag = False
        print(results)

        return max(results)%1337
