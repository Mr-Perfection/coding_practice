"""find the longest palindrome of a string?

abdba => abdba
abcbd => bcb
abba <- if a[index] and a[index+1] are equal, check index-i and index+1-i
aca <- check index - i and index + i
Approach #1: Keep track of the longest string
* longest = string[0]
* loop i from 0...length of string
	* longest = max(longest,longest_palindrome(string,index))
* return longest

			(abcbd,0,0,None,None)
			(abcbd,0,1,a,a)
			(abcbd,1,1,a,a)

Palindrome is string is same as reversed string.
Time O(n^2) space: O(1)
"""
def longest_palindrome(s, index):
	longest = s[index]
	# if s[index] and s[index+1] are same, check index-i and index+1-i
	longest = max(longest,longest_palindrome_helper(s,index,index+1),key=len)
	longest = max(longest,longest_palindrome_helper(s,index,index),key=len)

def longest_palindrome_helper(s, left, right):
	while left >= 0 and right < len(s):
		if s[left] != s[right]: break
		left -= 1
		right += 1
	return s[left+1:right]

def solution(string):
	longest = string[0]
	for i in range(len(string)):
		longest = max(longest,longest_palindrome(string,i),key=len)
	return longest
