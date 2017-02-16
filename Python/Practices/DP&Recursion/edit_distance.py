"""
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations.
Replace 'n' with 'r', insert t, insert a
"""
import time

def edit_dis(str1,str2):
    # if str1 or str2 are empty strings, return the remaining length of str1 or     # str2 (regarded as insertions or deletions)
    if len(str1) == 0:
        return len(str2)
    if len(str2) == 0:
        return len(str1)
    # if first elements of str1 and str2 are same then go to next elements
    #print("str1 is:",str1,"str2 is:",str2)
    if str1[0] == str2[0]:
        return edit_dis(str1[1:],str2[1:])
    # if str1[0] and str2[0] are different
    # 1) shift both strings to right (replace), 2) shift only longer string to right(remove), or (3) shift shorter string to right(insert)
    return 1 + min(edit_dis(str1[1:],str2[1:]),
                       edit_dis(str1,str2[1:]),
                       edit_dis(str1[1:],str2))

def edit_dis_memo(str1,str2,n,m,mem):
    # if str1 or str2 are empty strings, return the remaining length of str1 or     # str2 (regarded as insertions or deletions)
    if n == 0:
        return m
    if m == 0:
        return n
    if mem[n][m] > 0:
        return mem[n][m]
    # if first elements of str1 and str2 are same then go to next elements
    #print("str1 is:",str1,"str2 is:",str2)
    if str1[n] == str2[m]:
        return edit_dis_memo(str1,str2,n-1,m-1,mem)
    # if str1[0] and str2[0] are different
    # 1) shift both strings to right (replace), 2) shift only longer string to right(remove), or (3) shift shorter string to right(insert)
    mem[n][m] = 1 + min(edit_dis_memo(str1,str2,n-1,m-1,mem),
                   edit_dis_memo(str1,str2,n,m-1,mem),
                   edit_dis_memo(str1,str2,n-1,m,mem))
    return mem[n][m]

# time
# Driver program to test the functions above
def main():
    #n = len(arr)
    #start_time = time.time()
    print("Length of edit_distance is", edit_dis("geek","gesek"))
    #print("--- %s seconds ---" % (time.time() - start_time))
    print("Length of edit_distance is", edit_dis("cat","cut"))
    print("Length of edit_distance is", edit_dis("sunday","saturday"))


    start_time = time.time()
    s1,s2 = "sunday","saturdayr"
    print("Length of edit_distance is", edit_dis(s1,s2))
    print("--- %s seconds ---" % (time.time() - start_time))
    mem = [[0 for j in range(len(s2))] for i in range(len(s1))]
    start_time = time.time()
    print("Length of edit_distance is",
          edit_dis_memo(s1,s2,len(s1)-1,len(s2)-1,mem))
    print("--- %s seconds ---" % (time.time() - start_time))


if __name__=="__main__":
    main()
