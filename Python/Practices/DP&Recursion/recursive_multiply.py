'''
Recursive Multiply: Write a recursive function to multiply two positive integers without using the * operator.
 You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.

Addition?
5, 6 = 5 + 5 + 5 + 5 + 5 + 5
recurse 6 5 times and add all the results
time & space: O(n)

Bit shifting
5 = 00000101
6 = 00000110 ??? Not sure
'''
def recursive_multiply_helper(big,little):
    if little == 0:
        return 0
    return big + recursive_multiply_helper(big, little - 1)

def recursive_multiply(num1, num2):
    big = max(num1,num2)
    little = min(num1,num2)
    # if little is odd, result is big (little - 1) / 2 * 2 + big
    if little % 2 != 0:
        t = recursive_multiply_helper(big,(little - 1) / 2)
        return t + t + big
    # if big is even, result is big (little / 2)
    else:
        t = recursive_multiply_helper(big,little / 2)
        return t + t

# time & space: O(n)

print(recursive_multiply(4,3))


# make efficient?

def recursive_multiply_helper(big,little):

    # if little is 0, return 0
    if little == 0:
        return 0
    # if little if 1, return big
    if little == 1:
        return big

    # divide by two
    s = little >> 1
    half = recursive_multiply_helper(big, s)

    # if little is even
    # return half + half
    if little % 2 == 0:
        return half + half
    # if little is odd
    # return half + half + bigger
    else:
        return half + half + big



def recursive_multiply(num1, num2):
    big = max(num1,num2)
    little = min(num1,num2)
    return recursive_multiply_helper(big,little)

# log n
print(recursive_multiply(4,3))
