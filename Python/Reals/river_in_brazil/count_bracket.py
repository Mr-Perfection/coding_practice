"""
 for a string with '(' find the count of complete '()' ones, '(()))" does not count, if does not have full brackets, return -1
 time & space: O(n), n = length of S
"""
def count_brackets(S):
    # initializations
    cs,stack,cnt = S[:],[],0
    # iterate through char array of S
    for c in cs:
        # if it is '(', push this to stack
        if c == '(':
            stack.append(c)
        # if it is ')', pop element from the stack
        elif c == ')':
            # check if stack is empty
            if len(stack) == 0:
                #invalid
                return -1
            el = stack.pop()
            # check if element is '('
            if el == '(':
                # increments the count
                cnt += 1
    return cnt

test = "(())()"
print(count_brackets(test))
