# my failed attempt... logic was correct. O(n * k)
class Solution(object):
    def median(self,alist):
        srtd = sorted(alist)
        mid = int(len(alist)/2)
        if len(alist) % 2 == 0:
            return (srtd[mid-1] + srtd[mid]) / 2.0
        else:
            return srtd[mid] / 1.0
    def search_median(self,nums,index,k):
        windows = sorted(nums[:k])
        print(windows)
        return self.median(windows)

    def medianSlidingWindow(self, nums, k):
        """
        k = 3
        1  3 -1 -3  5  3  6  7
        ^  ^  ^
        Itereative approach:
         Time,space = O(n * k), O(k)
        """
        if len(nums) == 0:
            return []
        if k == 1 or len(nums) == 1:
            return map(lambda x: float(x), nums)
        results = []
        for i in range(len(nums)-k+1):
            results.append(self.search_median(nums,i,k))

        return results




# O(n*log(k))
class Solution(object):
    def medianSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[float]
        """
        if len(nums) == 0:
            return []
        if k == 1 or len(nums) == 1:
            return map(lambda x: float(x), nums)
        # general
        # function
        def BS(l,n):
            """
            :type l: List[int]
            :type n: int
            :rtype int
            """
            lo = 0
            hi = len(l)-1
            mi = 0
            while lo < hi-1:
                mi = lo + (hi-lo)/2
                if l[mi] == n:
                    return mi
                elif l[mi] < n:
                    lo = mi
                else:
                    hi = mi
            if l[mi] < n:
                while mi<len(l) and l[mi] < n:
                    mi += 1
                return mi
            else:
                while mi>=0 and l[mi] > n:
                    mi -= 1
                return mi + 1

        if k%2 == 1:
            # sort
            ori = sorted(nums[:k])
            result = [float(ori[len(ori)/2])]
            # loop
            for i in range(k,len(nums)):
                ori.remove(nums[i-k])
                new = ori
                new.insert(BS(new,nums[i]),nums[i])
                result.append(float(new[len(new)/2]))
                ori = new
        else:
            # sort
            ori = sorted(nums[:k])
            result = [float((ori[len(ori)/2-1]+ori[len(ori)/2])/2.)]
            # loop
            for i in range(k,len(nums)):
                ori.remove(nums[i-k])
                new = ori
                new.insert(BS(new,nums[i]),nums[i])
                result.append(float((new[len(new)/2-1]+new[len(new)/2])/2.))
                ori = new

        return result
