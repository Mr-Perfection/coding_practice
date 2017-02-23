# Write a function that retuns the power set of the input
# {1,2,3} -> [{},{1},{2},..,{1,2},{2,3},....{1,2,3}]0

'''
[1,2,3]
=> {}, {1},{2},{3},{1,2},{2,3},{1,3},{1,2,3}
=> list of sets

[{},{1},{2},{1,2},{3},{1,3},{2,3},{1,2,3}]
'''
# time: O(n^2^n) space: O(2^n)
# back tracking approach
def power_set_helper(A,pow_set,temp,index):
    # base case: if index >= length of A, return
    # check if temp not in pow_set
    if index > 0 and set(temp) not in pow_set:
        # push sublist of A into pow_set
        t = temp[:]
        pow_set.append(set(t))
    if index >= len(A):
        return
#     result = power_set_helper(A,pow_set,temp,i)
#     itemToAdd = A[index]

#     for subset in result:


    # iterate i from index + 1 to length of A
    for i in range(index,len(A)):
        # add element to temp
        temp.append(A[i])
        # recurse the function with index as i
        power_set_helper(A,pow_set,temp,i+1)
        # remove element from temp
        temp.pop()

def power_set(A):
    # check A is valid
    if not(A) or len(A) == 0:
        return None
    # intializations
    pow_set,combo = [{}],[]
    # call helper method
    power_set_helper(A,pow_set,[],0)
    # return the list
    return pow_set


print(power_set([1,2,3]))
