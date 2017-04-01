class Solution(object):
    def helper(self,string,left,right,mem):
        if left >= right: return 1
        if mem[left][right]: return mem[left][right]

        table = [0 for i in range(256)]
        s = string[left:right]
        for i in range(len(s)):
            if table[ord(s[i])]:
                mem[left][right] = max(self.helper(string,left+1,right,mem),self.helper(string,left+1,right-1,mem),self.helper(string,left,right-1,mem))
                return mem[left][right]
            else:
                table[ord(s[i])] += 1
        mem[left][right] = len(s)
        return mem[left][right]

    def lengthOfLongestSubstring(self, s):
        # using recursive appraoch
        table = [[0 for i in range(len(s)+1)] for i in range(len(s)+1)]
        if not(s): return 0
        return self.helper(s,0,len(s),table)




class Solution(object):
    def lengthOfLongestSubstring(self, s):
        # using greedy
        if not(s): return 0
        table = [False for i in range(256)]
        # start,longest = 0,0
        # table = {}
        start,end,longest = 0,0,1
        # iterate through the string
        # check if table already has string
        # if so, then reset the starting index and ending index
        # if not, then set the table to true and track the ending index
        # for i in range(len(s)):
        #     if table[ord(s[i])]:
        #         start = end = i + 1
        #         table[ord(s[i])] = False
        #     else:
        #         longest = max(longest,end-start+1)
        #         table[ord(s[i])] = True
        #     end += 1
        # return longest
        for i in range(len(s)):
            if s[i] in table and start <= table[s[i]]:
                start = table[s[i]] + 1
            else:
                longest = max(longest,i-start+1)
            table[s[i]] = i
        return longest
