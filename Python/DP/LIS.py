import time
"""
Longest Increasing Subsequence
arr = [10, 22, 9, 33, 21, 50, 41, 60, 80]
lis =  ^   ^      ^       ^       ^   ^ = 6

                                10(1+22(9))
                            22,     22(1+9(33))
                        9,            ...
                    33,
                21,
            50,
        41
    60
80

2^n Recursion
can be optimized by memoization
n^2 with Memo

"""


def lis(arr,n):
    # terminating conditino
    if n == 1:
        return 1
    # iterate through arr before n-1th element and call itself recursively with newly assigned Length 1+lis(arr,i)
    current = 1
    for i in range(0,n-1):
        temp = 1+lis(arr,i)
        # if it is increasing, get the max of current and temp
        if arr[i] < arr[n-1]:
            current = max(current,temp)
        else:
            # if that's not the case, current becomes temp
            current = temp
    return current

# optimized
def lis_mem(arr,n,mem):
    # terminating condition: when the length of arr is 1
    if n == 1:
        return 1
    if mem[n-1] > 0:
        return mem[n-1]
    current_lis_length = 1
    for i in range(0,n-1):
        temp = 1+lis(arr,i)
        if arr[i] < arr[n-1]:
            current_lis_length = max(current_lis_length,temp)
        else:
            current_lis_length = temp
    mem[n-1] = current_lis_length
    return mem[n-1]


# time
# Driver program to test the functions above
def main():
    arr = [10, 22, 9, 33, 21, 50, 41, 60]
    arr2 = [6,3,5,2,7,8,1]
    arr3 = [2,6,3,4,1,2,9,5,8,9]
    #n = len(arr)
    print("len of arr2",len(arr2))
    start_time = time.time()
    print("Length of LIS is", lis(arr, len(arr)))
    print("--- %s seconds ---" % (time.time() - start_time))
    memo = [0] * (len(arr))
    start_time = time.time()
    print("Length of LIS mem is", lis_mem(arr, len(arr),memo))
    print("--- %s seconds ---" % (time.time() - start_time))
    start_time = time.time()
    print("Length2 of LIS is", lis(arr2, len(arr2)))
    print("--- %s seconds ---" % (time.time() - start_time))
    memo = [0] * (len(arr2))
    start_time = time.time()
    print("Length2 of LIS is", lis_mem(arr2, len(arr2),memo))
    print("--- %s seconds ---" % (time.time() - start_time))

    start_time = time.time()
    print("Length3 of LIS is", lis(arr3, len(arr3)))
    print("--- %s seconds ---" % (time.time() - start_time))
    memo = [0] * (len(arr3)+1)
    start_time = time.time()
    print("Length3 of LIS is", lis_mem(arr3, len(arr3),memo))
    print("--- %s seconds ---" % (time.time() - start_time))



if __name__=="__main__":
    main()
