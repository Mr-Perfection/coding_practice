Given a string, find the longest palindrome.
You can shuffle or delete a char to find a longest palindrome string.


ababc => bab
my approach#1 (recursive appraoch)

def f(s,left,right,dp):
	if left >= right: return ''
	if s[left] == s[right]:
		return s[left] + f(s,left+1,right-1) + s[right]
	else:
		return max(s[left] + f(s,left,right-1), f(s,left-1,right) + s[right],key=len)




Given a list of integers return the the list…

ex)
input: {1,4,2,6}
get the index i  of 1: 0
the next greater value of 1 is: 2
the index j of next greater value: 2
 j - i = 2

output: {2,2, -1}


approach #1: using hashmap + list
given: 1, {1,4,2,6} O(n) O(n) n is total number of values in given list
1. itereate through list. O(n)
2. store all values into hashtable. value as key and index as value ex) {1:0}
3. iterate through list again O(n) and find values that are greater than given ex) 1 then store them into another list [4,2,6]
4. find min of [4,2,6] and get the index from hashtable table[2] = 2
5. return {2,2}
