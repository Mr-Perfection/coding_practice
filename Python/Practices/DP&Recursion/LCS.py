import time
# find a longest common subsequence of two strings
def lcs(str1, str2, index1,index2):
    if index1==0 or index2==0:
        return 0
    elif str1[index1-1] == str2[index2-1]:
        return 1 + lcs(str1,str2,index1-1,index2-1)
    else:
        return max(lcs(str1,str2,index1,index2-1),lcs(str1,str2,index1-1,index2))

def lcs_mem(str1,str2,index1,index2,mem):
    if index1==0 or index2==0:
        return 0
    if mem[index2-1][index1-1] != 0:
        return mem[index2-1][index1-1]
    if str1[index1-1] == str2[index2-1]:
        mem[index2-1][index1-1] = 1 + lcs_mem(str1,str2,index1-1,index2-1,mem)
    else:
        mem[index2-1][index1-1] = max(lcs_mem(str1,str2,index1-1,index2,mem),lcs_mem(str1,str2,index1,index2-1,mem))
    return mem[index2-1][index1-1]

# Driver program to test the above function
X = "AGGTAB"
Y = "GXTXAYB"
mem= [[0 for x in range(len(X))] for y in range(len(Y))]
#print(mem)
#start_time = time.time()
#print("Length of LCS is ", lcs(X , Y, len(X), len(Y)))
#print("--- %s seconds ---" % (time.time() - start_time))
start_time = time.time()
print("Length of LCS is ", lcs_mem(X , Y, len(X), len(Y),mem))
print("--- %s seconds ---" % (time.time() - start_time))


X = "ABCDGH"
Y = "AEDFHR"
mem= [[0 for x in range(len(X))] for y in range(len(Y))]
#print(mem)
#start_time = time.time()
#print("Length of LCS is ", lcs(X , Y, len(X), len(Y)))
#print("--- %s seconds ---" % (time.time() - start_time))
start_time = time.time()
print("Length of LCS is ", lcs_mem(X , Y, len(X), len(Y),mem))
print("--- %s seconds ---" % (time.time() - start_time))
