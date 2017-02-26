def is_palindrome(n):
    result = str(n)
    left,right = 0,len(result)-1
    while left < right:
        if result[left] != result[right]:
            return False
        left+=1
        right-=1
    return True

# O(n^2)
def palindrome_chain_length(n):
    # create a counter and set result to n
    cnt,result = 0, n
    # loop until result becomes palindrome
    #while not(is_palindrome(result)):
    while result != int(str(result)[::-1]):
        # result += int(s[::-1]), add reversed string to result
        result += int(str(result)[::-1])
        cnt += 1
    return cnt
