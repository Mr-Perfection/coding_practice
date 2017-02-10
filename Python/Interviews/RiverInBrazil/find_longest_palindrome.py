
"""
Consider two possible cases:
string is even or odd.
If string is odd, you start from one character
If string is even, you start from two characters
forgeeksskeegfor
^
Yes
forgeeksskeegfor
^^
Nope
forgeeksskeegfor
^^
Nope
"""

def expand_substring(s,i,j):
    while i >= 0 and j < len(s):
        if s[i] != s[j]:
            return s[i+1:j] #return previous two elements before i+1 j-1 (from left and right)
        i -= 1
        j += 1
    return s[i:j+1]

def longest_palindrome(s):
    n = len(s)

    if n == 0:
        return ''

    if n == 1:
        return s
    # the longest substring is s(0,1)
    longest = s[0:2]

    # loop 0..n-1th elements of s
    # expand substring to left and right and see if they are palindrome
    for i in range(n-1):
        sub1 = expand_substring(s,i,i) # start from ith position as a center

        if len(sub1) > len(longest): # check if new sub1 is greater than current longest
            longest = sub1

        sub2 = expand_substring(s,i,i+1) # start from ith and i+1th position as a center

        if len(sub2) > len(longest): # check if new sub2 is greater than current longest
            longest = sub2
    return longest

s = "forgeeksskeegfor"
print(longest_palindrome(s))
