"""
Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
The digits are stored in reverse order, such that the 1's digit is at the head of the list.
Write a function that adds the two numbers and returns the sum as a linked list.
Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).Thatis,617 + 295. Output: 9 -) 1 -) 2.That is, 912.

6 -> 1 -> 7
2 -> 9 -> 5
= 617 + 295 =912
returns 9 -> 1 -> 2

Approach #1: reverse lists and add with carry (O(n) time)
7 -> 1 -> 6
5 -> 9 -> 2

Approach #2: make them integers and add them. Then, make a linked-list
"""

d
