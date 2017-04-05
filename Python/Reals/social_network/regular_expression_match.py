Regular Expression Matching

class Solution(object):

    def check_str(self, s, index, letter):
            for i in range(index+1):
                if s[i] == '.' or s[i] == letter:
                    return True
            return False

    def isMatch(self, A, B):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        n,m = len(A), len(B)

        # initialize dp array
        dp = [[False for j in range(m+1)] for i in range(n+1)]
        dp[0][0] = True

        #empty string to nonempty pattern
        for i in range(1, m+1):
            if i > 1 and B[i-1] == '*':
                dp[0][i] = dp[0][i-2]

        # bottom-up
        for i in range(1,n+1):
            for j in range(1,m+1):
                #If the string char equals the pattern char or the pattern is a dot,
                #there is a match if everything before matches
                if B[j-1] == '.' or B[j-1] == A[i-1]:
                    dp[i][j] = dp[i-1][j-1]
                # star can only match if there is something before star to match
                elif j > 1 and B[j-1] == '*':
                    # if charcter of B before '*' matches with current char of A or .
                    if B[j-2] == A[i-1] or B[j-2] == '.':
                        # if B[j-2] character mathces with current A el.
                        # or if B[j-2] is '.'
                        dp[i][j] = dp[i][j-2] or dp[i-1][j]
                    else:
                        # just store previous of previous
                        dp[i][j] = dp[i][j-2]

        # print(dp)
        return dp[n][m]



# very close but not working.
class Solution(object):

    def check_str(self, s, index, letter):
            for i in range(index+1):
                if s[i] == '.' or s[i] == letter:
                    return True
            return False

    def isMatch(self, A, B):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        m,n = len(A), len(B)

        # initialize dp array
        dp = [[False] * (n+1)] * (m+1)
        dp[0][0] = True
        # initialize first column of DP 1...m
        # for i in range(1,m+1):
        #     if A[i-1] == '*' and dp[i-1][0]:
        #         dp[i][0] = True

        # print(dp)
        # initialize first row of DP 1...n
        for i in range(1,n+1):
            if B[i-1] == '*' and dp[0][i-1]:
                dp[0][i] = True
        # print(dp)
        # bottom-up
        for i in range(1,m+1):
            for j in range(1,n+1):
                if A[i-1] == B[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                elif B[j-1] == '*':
                    if self.check_str(B, j-1, A[i-1]):
                        dp[i][j] = True
                elif A[i-1] == '*':
                    if self.check_str(A, i-1, B[j-1]):
                        dp[i][j] = True
                elif A[i-1] == '.' or B[j-1] == '.':
                    dp[i][j] = True
        print(dp)
        return dp[m][n]
