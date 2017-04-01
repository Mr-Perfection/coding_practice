# 29 / 37 test cases passed.
# Using DFS... There are other answers but i think
#  this is good enough for the interview
class Solution(object):
    def helper(self,s,output,result,dict):
        # base case
        if not(s):
            result.append(' '.join(output))
            return

        # loop i from 0...len(s)
        for i in range(0,len(s)+1):
            if s[0:i] in dict:
                output.append(s[0:i])
                self.helper(s[i:],output,result,dict)
                output.pop()

    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        output = []
        result = []
        self.helper(s,output,result,wordDict)
        return result
