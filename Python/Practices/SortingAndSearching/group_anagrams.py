from itertools import groupby

"""Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to each other.

['abc','bacd','abc',bacd'] => ['abc','abc',bacd','bacd']

sort by the string length

time: O(n log n)
space: O(n)
"""

def group_anagrams(a):
    # check if a is nil
    if len(a) == 0:
        return None
    # initializations
    #result = []
    # sort alphabetical order and string length
    a.sort()
    a.sort(key=len)
    # group the elements by the length of a string
    # a = [list(group) for key,group in groupby(a,len)]
    # # "flatten" the list 2D -> 1D
    # for el in a:
    #     result += el
    # return result
    return a


x = ['zxy','zxyz','abc','bacd','abc','xyz','bacd','zxy']

print(group_anagrams(x))

#x = list(map((lambda a: a.split()), x))

#print(list(map( lambda a: sorted(a.split()), x)))
