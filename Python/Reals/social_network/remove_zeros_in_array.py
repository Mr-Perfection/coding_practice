"""
remove all zeros from a given array

[1,0,0,2,3,4]
[1,0,2,3,0,4]
O(n^2) approach
Using two iterations with i and j loops. j loop is i+1..n-1
Using built-in function pop(index)

O(n log n)
Sort an array in increasing order and loop until there is no zeros (and pop all the zeros in front)

O(n)
Using pointer with swaps?
Two pointers: i, ptr_to_last_zero
[1,0,2,3,0,4]
[1,0,2,3,0,4]
   i-> ^ ^ <-pointer to last zero
[1,0,2,0,3,4]
     ^ ^
[1,0,0,2,3,4]
 ^   ^
 [0,0,1,2,3,4]
  ^   ^ Done
  remove all zeros from the front
  [1,2,3,4]
"""
