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

Solution 1: O(n) <- selected!
iterate through the entire list to find the matched string and skip the empty string.

Solution 2: O(log n)
use modified binary search to find the input. When encountered empty string, skip it. Nope does not work. what if the middle is empty string?

EXAMPLE
Input:ball
Output: 4

"""


def sparse_search(array, target)
  # check if array exists
  return -1 if array == nil || array.empty?
  # initializations
  i = 0
  # loop through the array
  while i < array.length
    # skip empty or nil strings
    i += 1 while array[i] == nil || array[i] == ''
    # check if element is equal to target
    return i if array[i] == target
    i += 1
  end
end

def sparse_search(array, target)
  # check if array exists
  return -1 if array == nil || array.empty?
  return array.index(target)
end

a = ['abc','','','', 'ball',nil,'', 'fox','','', 'ggdag','','', 'ggg','','', 'ggga', 'kioke']
print(a,"\n")
print(sparse_search(a,'fox'))
