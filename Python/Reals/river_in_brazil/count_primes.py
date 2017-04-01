class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int

        Approach #1 O(n*k) k is number of primes:
        * loop number i from 2..n-1
            * if number i is even and > 2, then continue
        * loop number p in primes[]
            * if i % p == 0
                * continue
        * store i into primes
        * increment i
        n = 4
        2,3,4
        n = 9
        2,3,4,5,6

        2,3,4,5,6,7,8
        2,3,4,5
        * loop number i from 2...n
            * if i not in numbers{}
                * numbers{}.add(i)
                * increment cnt
            * else
                * continue
            * if i * i < n and i * i not in numbers{}
                * numbers.add(i*i)
            * if i * 2 < n and n * 2 not in number{}
                * numbers.add(i*2)
        """
        # 19/20, memory exceeded
        # if n < 2: return 0
        # cnt = 0
        # numbers = [False]*n
        # for i in range(2,n):
        #     if not(numbers[i]):
        #         cnt += 1
        #         for j in range(i,n,i):
        #             numbers[j] = True

        # return cnt

        if n < 3: return 0
        cnt = 0
        primes = [True]*n
        primes[0] = False
        primes[1] = False
        for i in range(2,int(n**0.5)+1):
            if primes[i]:
                cnt += 1
                for j in range(i*i,n,i):
                    primes[j] = False

        return sum(primes)
            
