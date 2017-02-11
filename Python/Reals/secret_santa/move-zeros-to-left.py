



# Given an array of integers:
# [3, 1, 5, 0, 6, 8, 0, 9, 2, 0]
# Push all the zeros to the front of the array

xs = [3, 1, 0, 5, 0, 6, 8, 0, 9, 2, 0]

def sortZeros_not_in_place(xs):
    ts = []
    for x in xs:
        if x == 0:
            ts.append(x)

    for x in xs:
        if x != 0:
            ts.append(x)

    return ts

# time: O(n + n) = 2n = n
# space: O(n)

# print(sortZeros_not_in_place(xs))

def shiftZeroToRight(xs, index):
    i = index
    while i > 0:
        xs[i] = xs[i-1]
        i -= 1
    xs[i] = 0

def sortZeros_in_place_old(xs):
    for i in range(len(xs)):
        if xs[i] == 0:
            shiftZeroToRight(xs, i)
    return xs

# time: O(n * m) n = len of xs, m = len of i <= len of xs
# time: O(n^2)
# space: O(1)

# print(sortZeros_in_place_old(xs))

# Time complexity of n
# In place (space complexity of O(1))
# Retain order
# [3, 1, 5, 0, 6, 8, 0, 9, 2, 0]
#                          ^  ^
#                          i  ptrToRightmostZero
# [3, 1, 5, 0, 6, 8, 0, 9, 0, 2]
#                       ^  ^
#                       i  ptrToRightmostZero
# [3, 1, 5, 0, 6, 8, 0, 0, 9, 2]
#                 ^     ^
#                 i     ptrToRightmostZero
# [3, 1, 5, 0, 6, 0, 0, 8, 9, 2]
#              ^     ^
#              i     ptrToRightmostZero
# [3, 1, 5, 0, 0, 0, 6, 8, 9, 2]
#        ^        ^
#        i     ptrToRightmostZero
# [3, 1, 0, 0, 0, 5, 6, 8, 9, 2]
#     ^        ^
#     i     ptrToRightmostZero
# [3, 0, 0, 0, 1, 5, 6, 8, 9, 2]
#  ^        ^
#  i        ptrToRightmostZero
# [0, 0, 0, 3, 1, 5, 6, 8, 9, 2]
#  ^     ^
#  i     ptrToRightmostZero
# [0, 0, 0, 3, 1, 5, 6, 8, 9, 2]

def sort_zeros_in_place(xs):
    ptr_to_rightmost_zero = -1
    # Find rightmost zero
    for j in range(len(xs) - 1, -1, -1):
        if xs[j] == 0:
            ptr_to_rightmost_zero = j
            break

    for i in range(ptr_to_rightmost_zero - 1, -1, -1):
        if xs[i] != 0:
            xs[i], xs[ptr_to_rightmost_zero] = xs[ptr_to_rightmost_zero], xs[i]
            ptrToRightmostZero -= 1
    return xs


# Time O(2n) = O(n)
# Space O(1)

print(sortZeros_in_place(xs))








# Given an array of integers:
# [3, 1, 5, 0, 6, 8, 0, 9, 2, 0]
# Push all the zeros to the front of the array


xs = [3, 1, 0, 5, 0, 6, 8, 0, 9, 2, 0]

def sortZeros_not_in_place(xs):
    ts = []
    for x in xs:
        if x == 0:
            ts.append(x)

    for x in xs:
        if x != 0:
            ts.append(x)

    return ts

# time: O(n + n) = 2n = n
# space: O(n)

# print(sortZeros_not_in_place(xs))

def shiftZeroToRight(xs, index):
    i = index
    while i > 0:
        xs[i] = xs[i-1]
        i -= 1
    xs[i] = 0

def sortZeros_in_place_old(xs):
    for i in range(len(xs)):
        if xs[i] == 0:
            shiftZeroToRight(xs, i)
    return xs

# time: O(n * n)
# time: O(n^2)
# space: O(1)

# print(sortZeros_in_place_old(xs))

# Time complexity of n
# In place (space complexity of O(1))
# Retain order
# [3, 1, 5, 0, 6, 8, 0, 9, 2, 0]
#                          ^  ^
#                          i  ptrToRightmostZero
# [3, 1, 5, 0, 6, 8, 0, 9, 0, 2]
#                       ^  ^
#                       i  ptrToRightmostZero
# [3, 1, 5, 0, 6, 8, 0, 0, 9, 2]
#                 ^     ^
#                 i     ptrToRightmostZero
# [3, 1, 5, 0, 6, 0, 0, 8, 9, 2]
#              ^     ^
#              i     ptrToRightmostZero
# [3, 1, 5, 0, 0, 0, 6, 8, 9, 2]
#        ^        ^
#        i     ptrToRightmostZero
# [3, 1, 0, 0, 0, 5, 6, 8, 9, 2]
#     ^        ^
#     i     ptrToRightmostZero
# [3, 0, 0, 0, 1, 5, 6, 8, 9, 2]
#  ^        ^
#  i        ptrToRightmostZero
# [0, 0, 0, 3, 1, 5, 6, 8, 9, 2]
#  ^     ^
#  i     ptrToRightmostZero
# [0, 0, 0, 3, 1, 5, 6, 8, 9, 2]

def sort_zeros_in_place(xs):
    ptr_to_rightmost_zero = -1
    # Find rightmost zero
    for j in range(len(xs) - 1, -1, -1):
        if xs[j] == 0:
            ptr_to_rightmost_zero = j
            break

    for i in range(ptr_to_rightmost_zero - 1, -1, -1):
        if xs[i] != 0:
            xs[i], xs[ptr_to_rightmost_zero] = xs[ptr_to_rightmost_zero], xs[i]
            ptr_to_rightmost_zero -= 1

    return xs

# Time O(2n) = O(n)
# Space O(1)

print(sort_zeros_in_place(xs))
