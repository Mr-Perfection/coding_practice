
Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.



# best solution

class Solution(object):

    def findLUSlength(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: int
        """
        if a == b: return -1
        return len(a) if len(a) > len(b) else len(b)



# overkill....
class Solution(object):

    def helper(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: int
        """
        if not(a) or not(b):
            return abs(len(a)-len(b))

        if a[0] != b[0]:
            return 1 + self.helper(a[1:], b[1:])
        else:
            return max(self.helper(a, b[1:]), self.helper(a[1:], b))

    def findLUSlength(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: int
        """
        if a == b: return -1
        if not(a) or not(b):
            return abs(len(a)-len(b))

        res = self.helper(a,b)
        return res if res > 0 else -1
