import math
"""
a = cde
b = abc
ascii? O unicode? X

arr = [256]
O(n) approach

"""
def number_needed(a, b):
    # edge cases
    if not(a) or not(b) or\
       len(a) == 0 or len(b) == 0:
        return len(a) if not(b) or len(b) == 0 else len(b)
    cnt = 0
    # create arr with 256 letters initialized to 0
    arr = [0 for i in range(256)]
    # for i from 0...len(a)-1
    for i in range(len(a)):
        # arr[int(a[i])] += 1
        arr[ord(a[i])] += 1
    # for i from 0...len(b)-1
    for i in range(len(b)):
        # if arr[int(b[i])] <= 0
        arr[ord(b[i])] -= 1
    for i in range(len(arr)):
        if 0 < arr[i] or arr[i] < 0:
            cnt += abs(arr[i])
    return cnt

a = input().strip()
b = input().strip()

print(number_needed(a, b))
