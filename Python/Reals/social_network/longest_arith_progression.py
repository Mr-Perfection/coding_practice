"""
Longest Arithmetic Progression
http://www.geeksforgeeks.org/length-of-the-longest-arithmatic-progression-in-a-sorted-array/
set[] = {1, 7, 10, 15, 27, 29}
output = 3
The longest arithmetic progression is {1, 15, 29}
29 - 27 = 2 add + 1
27 - 15 = 12 , go to next index 2 < 12 return 0
29 - 15 = 14, add + 1
15 - 10 = 5
15 - 7 = 8
15 - 1 = 14, add + 1



set[] = {5, 10, 15, 20, 25, 30}
output = 6
The whole set is in AP


"""
# Meh....Pretty hard...
def lap(values):
    # check if values is None
    if not(values) or len(values) == 0:
        return 0
    # initializations
    result = 2
    # loop through all the values from reverse order
    for i in range(len(values)-1, 0):
        diff, src = values[i] - values[i - 1], values[i]
        result = max(result, 2 + lap_helper(values[0:i-1],diff, src))
    # return the maximum value
    return result

def lap_helper(values,diff,src):

    cnt = 0
    # loop through the rest (all elements - last)
    for i in range(len(values) - 1, -1):
        if (src - values[i]) % diff == 0:
            cnt += 1
    return cnt
