"
Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order.

a = [1,2,4,6]
b = [3,5]

result = [1,2,3,4,5,6]

bruteforce? O(n^3)
add b to a and sort O(n log n)


"

def sorted_merged(a,b)
  # Goal: merge sorted array b into a
  # check if a or b is nil. If true, return nil
  return if a.nil? || b.nil?
  # initialization
  # get length of a and b
  n,m = a.count { |x| x != nil }, b.length
  merged_index,indexA,indexB = n + m - 1,n-1,m-1
  i = merged_index

  while indexB >= 0
    # if a[indexA] > b[indexB] then store a[indexA] into a[merged_index]
    if indexA >= 0 and a[indexA] > b[indexB]
      a[i] = a[indexA]
      indexA -= 1
    else
      a[i] = b[indexB]
      indexB -= 1
    end
    i -= 1
  end



  # iterate
end

a = [1,2,4,6,nil,nil]
b = [3,5]
sorted_merged(a,b)
print a
