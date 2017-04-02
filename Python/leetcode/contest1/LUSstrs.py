Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

class Solution(object):
    """
    compare_strs
    returns true if s1 and s2 are same
    return false if s1 and s2 are not the same or same but different length
    """
    def compare_strs(self, s1, s2):
        j = 0
        for i in range(len(s1)):
            while j < len(s2) and s2[j] != s1[i]: j += 1
            if j == len(s2): return False
            j += 1
        return True
    def findLUSlength(self, strs):
        n = len(strs)
        ans = -1

        for i in range(n):
            cnt = 0
            for j in range(n):
                # looking for str[i] that does not have any duplicates
                if self.compare_strs(strs[i],strs[j]):
                    cnt += 1
            if cnt == 1:
                if len(strs[i]) > ans:
                    ans = len(strs[i])
        return ans
