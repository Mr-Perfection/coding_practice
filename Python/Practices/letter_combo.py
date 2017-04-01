class Solution(object):
    def generate_combo(self,result,letters):
        t_res = []
        for s in result:
            for l in letters:
                t_res.append(s+l)
        return t_res
    def letterCombinations(self, digits):
        if not(digits): return []
        kwords = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        result = list(kwords[digits[0]])
        for i in range(1,len(digits)):
            result = self.generate_combo(result,kwords[digits[i]])
        return result
