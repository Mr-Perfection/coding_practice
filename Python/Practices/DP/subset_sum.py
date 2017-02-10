"""
Dynamic Programming | Set 25 (Subset Sum Problem)
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
n=len(set)=6
                                        (6,9)
                                (5,9-2)             (5,9)
                    (4,7-5)         (5,7)       (4,9-5)   (4,9)
            (3,2-12)      (3,2)    (4,7-5)  (3,4-12)  (3,4)
            F          (2,2-4)(2,2)                  (2,4-4)
                       F      (1,2-3)                T <-True
                              F

"""

def subset_sum(l,n,total):
    if total < 0:
        return False
    if total == 0:
        return True
    if n <= 0:
        return False
    return max(subset_sum(l,n-1,total-l[n-1]),subset_sum(l,n-1,total))

def subset_sum_mem(l,n,total,mem):
    if total < 0:
        return False
    if total == 0:
        return True
    if n <= 0:
        return False
    #print(n-1,total)
    #print("mem",len(mem),len(mem[0]))
    if mem[n-1][total] > -1:
        return mem[n-1][total]
    mem[n-1][total] = max(subset_sum(l,n-1,total-l[n-1]),subset_sum(l,n-1,total))
    return mem[n-1][total]

def main():
    arr = [42, 3, 32, 42, 10, 22]
    n =len(arr)
    s = 42
    mem = [[-1 for j in range(s+1)] for i in range(n)]
    #print("test",arr[n-1:],arr[:n-1])
    # print(partition(arr,len(arr)))
    #arr = [1, 6, 11, 6]
    #arr.sort()
    
    # print(partition_m(arr,len(arr),mem))

    print(subset_sum(arr,n,s))
    print(subset_sum_mem(arr,n,s,mem))
    #print("--- %s seconds ---" % (time.time() - start_time))

if __name__=="__main__":
    main()
