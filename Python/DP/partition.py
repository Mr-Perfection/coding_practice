"""Partition a set into two subsets such that the difference of subset sums is minimum
Given a set of integers, the task is to divide it into two sets S1 and S2 such that
the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements,
Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11

1. First sort arr: arr[] = 1,5,6,11
2. Start from the last element and find the min: min(sum(arr[n-1:])-sum(arr[:n-1]),partition(arr,n-1))
"""
import time

def partition(arr,n):
    if n == 0:
        return abs(sum(arr[1:])-sum(arr[:1]))
    # check the previous value
    val = partition(arr,n-1)
    return min(abs(sum(arr[n-1:])-sum(arr[:n-1])),val)

def partition_m(arr,n,mem):
    if n == 0:
        return abs(sum(arr[1:])-sum(arr[:1]))
    if mem[n-1] > 0:
        return mem[n-1]
    # check the previous value
    mem[n-1] = min(abs(sum(arr[n-1:])-sum(arr[:n-1])),partition(arr,n-1))
    print(mem[n-1])
    return mem[n-1]
# time
# Driver program to test the functions above
def main():
    arr = [3, 1, 4, 2, 2, 5]
    n =len(arr)
    arr.sort()
    #print("test",arr[n-1:],arr[:n-1])
    #print(partition(arr,len(arr)))
    arr = [1, 6, 11, 6]
    arr.sort()
    mem = [0] * len(arr)
    start_time = time.time()
    """This case... Memoization is useless. there are no overlapping sub problems. O(n)"""
    print(partition_m(arr,len(arr),mem))
    print("--- %s seconds ---" % (time.time() - start_time))
    start_time = time.time()
    print(partition(arr,len(arr)))
    print("--- %s seconds ---" % (time.time() - start_time))

if __name__=="__main__":
    main()
