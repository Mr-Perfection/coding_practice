class Solution(object):

    def extend_pal(self,s,left,right):
        start,end = left,0
        while left >= 0 and right < len(s) and\
              s[left] == s[right]:
            end = right
            start = left
            left -= 1
            right += 1
        #print(s[start:end+1])
        return s[start:end+1]


    def longestPalindrome(self, s):
        end = 0
        start = 0
        longest = s[0]
        if not(s): return ''

        for i in range(int(len(s))):
            longest = max(longest, self.extend_pal(s,i,i),key=len)
            longest = max(longest, self.extend_pal(s,i,i+1),key=len)

        return longest






        
