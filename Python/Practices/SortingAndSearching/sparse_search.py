"""
Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
method to find the location of a given string.

a = ['abc','','','', 'ball','', 'fox','', 'ggdag','', 'ggg','','', 'ggga', 'kioke']

['abc','','','', 'ball','', 'fox','', 'ggdag','', 'ggg','','', 'ggga', 'kioke']
                                        ^
['abc','','','', 'ball','', 'fox','', 'ggdag','', 'ggg','','', 'ggga', 'kioke']
                                        ^ compare the first char. f < g, go left!
['abc','','','', 'ball','', 'fox','', 'ggdag','', 'ggg','','', 'ggga', 'kioke']
                         ^ empty string detected


Are the strings case-sensitive? All lowercased?

can i use sort again?

can i use built-in function?

Solution 1: O(n) <- selected!
iterate through the entire list to find the matched string and skip the empty string.

Solution 2: O(log n)
use modified binary search to find the input. When encountered empty string, skip it. Nope does not work. what if the middle is empty string?

EXAMPLE
Input:ball
Output: 4

"""



a = ['abc','','','', 'ball',None,'', 'fox','','', 'ggdag','','', 'ggg','','', 'ggga', 'kioke']
print(a)

def sparse_search(array, target):
    # check if array is None or empty
    if array == None or len(array) == 0:
        return -1
    # initializations
    i = 0
    # while loop through the list
    while i < len(array):
        # while loop through the list if encountered empty string
        while array[i] == None or len(array[i]) == 0:
            i += 1
        # check if element is equal to target
        if array[i] == target:
            # return the index if matched
            return i
        i += 1
    # not found
    return -1

def sparse_search(array, target):
    return array.index(target)

print(sparse_search(a,'fox'))
