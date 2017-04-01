class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not(prices): return 0
        buy,ret = prices[0],0
        for i in range(1,len(prices)):
            calc = prices[i] - buy
            if calc > 0:
                ret = max(ret,calc)
            buy = min([prices[i],buy])
        return ret
        
