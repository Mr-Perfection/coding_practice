#given a string of integer find out all the possible conversions to string
#'215' -> 'bae','ue','bm' -> 3
#'1'->'a'
#'2'->'b'
#'2 6'->'z'


"""
223 - 1 + 1
(S,index):

if S[index-1 assume >0] is in {'0','1'}:
    return 1
elif =='2'
    if S[index] is in {1,2,3,4,5,6,0}"
    return 1
else"
    return 0




215, ''
215, '2'
215, '21'
215, '215', return 1
215, '215', return 1

input: a string of ints
output: count of all possible conversions

(string,sub1,sub2,sub3,index)
('215',[], [], [], 0)
('215',[], [2], [15], 0) return 1 + recurrence
...

My approach #1 (using recursion):
    have three substrings sub1,sub2,sub3
    increments index every time there is a recurrence
    have a i that increments from index+1 to length of input
    sub1 = string[0:index] sub2 = string[index:i] sub3 = string[i:len(input)]
    
    
"""
# index = len(S)-1
def find_conversions(S,index):
    # base case: if index > length of S
    if index > len(S):
        return 0
    elif index-1  == -1:
        # terminate
        return 1 + find_conversions(S,index+1)
    else:
        if S[index-1 assume >0] is in {'0','1'}:
            return 1
        elif =='2':
            if S[index] is in {1,2,3,4,5,6,0}"
            return 1
        else:
            return 0