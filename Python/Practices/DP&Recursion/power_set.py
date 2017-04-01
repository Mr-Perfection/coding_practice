"""
Power Set: Write a method to return all subsets of a set.
is the input set() or list?
I assumed it is a list. Set contains unique values
input:
[1,2,3,4]
output:
        [1,2,3,4]

"""

def power_set(A):
    # initializations
    subset, powerset, index = [], [], -1
    power_set_helper(A, index, powerset, subset)
    print(powerset)

count = 1
def power_set_helper(A,index,powerset,subset):
    global count
    # if index >= length of A, return
    print(count)
    count+=1
    if index >= len(A):
        return
    #check if powerset contains subset
    #print(subset,subset in powerset)
    new_set = subset[:]
    if new_set in powerset:
        return
    else:
        #print(new_set)
        # if false, add subset to powerset
        powerset.append(new_set)
    # iterate i + 1 from index to length of A - 1
    for i in range(index+1, len(A)):
        # add a A[i] into subset
        subset.append(A[i])
        # recurse this function with new subset
        power_set_helper(A,i,powerset,subset)
        # remove a A[i] from subset
        subset.pop()

A = [1,2,3,4,5]
print(power_set(A))




def power_set(index,arr,subset,powerset):

    # check is subset is not in powerset
    if subset not in powerset:
        powerset.append(subset[:])

    # base case
    if index >= len(arr):
        return

    # core logic, backtracking
    for i in range(index,len(arr)):
        subset.append(arr[i])
        power_set(i+1,arr,subset,powerset)
        subset.pop()

def solution(array):
    subset,powerset = [],[]
    power_set(0,array,subset,powerset)
    return powerset

A = [1,2,3]
print(solution(A))
# time: O(n*2^n)
