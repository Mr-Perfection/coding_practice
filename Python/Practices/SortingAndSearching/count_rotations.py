def count_rotations(A,left,right):
  if A[left] <= A[right]: return 0
  mid = int((right+left)/2)
  value = count_rotations(A,left,mid)
  if value: return value
  else: return A[left]-A[right]

arr = [5,1,2,3,4]
arr = [2,3,4,5,1]
arr = [1,2,3,4,5]
print(count_rotations(arr,0,len(arr)-1))
