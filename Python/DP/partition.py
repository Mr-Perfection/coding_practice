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

get the total of arr
sum(arr) = 1+6+11+5=23
                23
        23-5(5)         23    (5)
                    23-11 23     (11)
                12-6  12     23     (6) mem[2][23]=
            6-1                23    (1)
            mem[1][23]=min(abs(23-1-1=21), abs(23-0-0=23))

                        23
                23-5(5)        23    (5)
            23-11                 23     (11)
                12-6 12               23     (6)
            6-1                            23    (1)
                            return min(abs(23-5-5=13),     abs(23-0-0=23))

"""
import time
# counter = 0
# time: O(2^n),
def partition_helper(arr,n,sub,total):
    # global counter
    if n == 0:
        return abs(total-sub-sub)

    return min(partition_helper(arr,n-1,sub+arr[n-1], total),partition_helper(arr,n-1,sub, total))

# time: O(n*SUM)
def partition_helper_mem(arr,n,sub,total,mem):
    # global counter
    if n == 0:
        return abs(total-sub-sub)
    if mem[n-1][total-sub] > -1:
        return mem[n-1][total-sub]
    # print("A",counter)
    # counter+=1
    #counter+=1
    mem[n-1][total-sub] = min(partition_helper_mem(arr,n-1,sub+arr[n-1], total,mem),partition_helper_mem(arr,n-1,sub, total,mem))
    #print(mem[n-1][total-sub],n-1,total)
    return mem[n-1][total-sub]

def partition(arr):
    total = sum(arr)
    mem = [[-1 for j in range(total+1)] for i in range(len(arr))]


    start_time = time.time()
    val = partition_helper_mem(arr,len(arr),0,total,mem)
    print("--- %s seconds 1st ---" % (time.time() - start_time))
    print(val)
    start_time = time.time()
    val = partition_helper(arr,len(arr),0,total)
    print("--- %s seconds 2nd---" % (time.time() - start_time))
    print(val)


# def partition_m(arr,n,mem):
#     if n == 0:
#         return abs(sum(arr[1:])-sum(arr[:1]))
#     if mem[n-1] > 0:
#         return mem[n-1]
#     # check the previous value
#     mem[n-1] = min(abs(sum(arr[n-1:])-sum(arr[:n-1])),partition_m(arr,n-1))
#     print(mem[n-1])
#     return mem[n-1]
# time
# Driver program to test the functions above
def main():
    arr = [42, 3, 32, 42, 10, 22]
    n =len(arr)
    #print("test",arr[n-1:],arr[:n-1])
    # print(partition(arr,len(arr)))
    #arr = [1, 6, 11, 6]
    #arr.sort()

    # print(partition_m(arr,len(arr),mem))

    print(partition(arr))
    #print("--- %s seconds ---" % (time.time() - start_time))

if __name__=="__main__":
    main()
