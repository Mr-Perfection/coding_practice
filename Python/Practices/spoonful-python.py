# https://jeremykun.com/2012/01/12/a-spoonful-of-python/

myList = ['a', 2, "gamma", ["wtf another list!", 5]]
myList[-1] = "replacing the list by a string"
myList.append(myList[2:4])
secondList = [2*i for i in range(10)]
"""
As in the second line, we can use negative indices to access the elements in reverse order.
In the third, we can access slices of the list using the colon notation.
And in the last line, we have the generally awesome and useful list comprehensions.
This follows more or less closely with the usual notation for constructing lists (of course, using Pythonic syntax).
 However, one must be careful, because each “for” in a list comprehension literally corresponds to an actual for loop.
 In other words, the following two bits of code are equivalent:
"""

myList = [x*y*z for x in range(100) for y in range(100) for z in range(100)]
myList = []
for x in range(100):
   for y in range(100):
     for z in range(100):
        myList.append(x*y*z)

"""
On the other hand, tuples have almost precisely the same syntax, except they are constructed with parentheses,
and tuple comprehensions have an extra bit of syntax. Here are the same examples as above, except with tuples.
"""
myTuple = ('a', 2, "gamma", ("wtf another tuple!", 5))
myTuple[-1] = 2 # not allowed to assign!
myTuple.append(myTuple[2:4]) # not allowed to append!
secondTuple = tuple(2*i for i in range(10))
