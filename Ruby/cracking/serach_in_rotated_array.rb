"
Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown number of times,
write code to find an element in the array. You may assume that the array was originally sorted in increasing order.

is the rotation clockwise??
I assumed it is.

[1,2,3,4,5]
rotated n number of times...
[3,4,5,1,2]

[4,5,1,2,3] check mid -1 and mid + 1 value

O(n) approach:
iterate through the entire array and find the match

O(log n) approach:
binary search?
"

def search_in_rotated(a,left,right,value)
  # check if a is blank or left exceeds right
  return -1 if left >= right || a.nil?
  # check the middle is the answer
  mid = (left + right) / 2
  return mid if a[mid] == value
  # recurse through left and right
  x = search_in_rotated(a,left,mid,value)
  y = search_in_rotated(a,mid+1,right,value)
  return [x,y].max
end

a = [4,5,6,7,8,1,2,3]
val = 3
print(search_in_rotated(a,0,a.length,val))
