class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        letters = [0 for i in range(256)]
        for i in range(len(s)):
            letters[ord(s[i])] += 1
        for i in range(len(t)):
            letters[ord(t[i])] -= 1
        for i in range(len(letters)):
            if letters[i] != 0:
                return False
        return True
