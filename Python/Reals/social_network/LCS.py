import sys

import sys
# 2/4 2 timeouts
def LCS(A,B,a,b,mem):
    if a >= len(A) or b>= len(B):
        return ''
    if mem[a][b]:
        return mem[a][b]
    if A[a] == B[b]:
        mem[a][b] = A[a] + ' ' + LCS(A, B, a+1,b+1, mem)
    else:
        mem[a][b] = max(LCS(A, B, a+1, b, mem),LCS(A, B, a, b+1, mem),key=len)
    return mem[a][b]


n,m = input().split(' ')
A = input().split(' ')
B = input().split(' ')
ans = []
res = []
mem = [[None for j in range(len(B))] for i in range(len(A))]
longest = LCS(A,B,0,0,mem)
#for sub in res:
#    longest = max(sub,longest,key=len)
#print(mem)
print(longest)

import sys
# 2/4 2 timeouts
def LCS(A,B,a,b):
    if a >= len(A) or b>= len(B):
        return ''

    if A[a] == B[b]:
        ans.append(A[a])
        return A[a] + ' ' + LCS(A, B, a+1,b+1)
    else:
        return max(LCS(A, B, a+1, b),LCS(A, B, a, b+1),key=len)


n,m = input().split(' ')
A = input().split(' ')
B = input().split(' ')
ans = []
res = []
longest = LCS(A,B,0,0)
#for sub in res:
#    longest = max(sub,longest,key=len)
print(longest)


# 2/4 2 timeouts
def LCS(A,B,a,b,ans,sol):
    if a >= len(A) or b>= len(B):
        sol.append(ans[:])
        return

    if A[a] == B[b]:
        ans.append(A[a])
        LCS(A, B, a+1,b+1, ans, sol)
        ans.pop()
    else:
        LCS(A, B, a+1, b, ans, sol)
        LCS(A, B, a, b+1, ans, sol)


n,m = input().split(' ')
A = input().split(' ')
B = input().split(' ')
ans = []
res = []
LCS(A,B,0,0,ans,res)
longest = res[0]
for sub in res:
    longest = max(sub,longest,key=len)
print(' '.join(longest))
