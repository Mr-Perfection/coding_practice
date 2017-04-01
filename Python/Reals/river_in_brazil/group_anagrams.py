class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        ret,table = [],{}
        for i in range(len(strs)):
            s = str(sorted(strs[i]))
            if s in table:
                table[s].append(strs[i])
            else:
                table[s] = [strs[i]]

        for key in table: ret.append(table[key])
        return ret
