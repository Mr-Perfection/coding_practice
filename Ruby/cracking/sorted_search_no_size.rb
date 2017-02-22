"
Sorted Search, No Size: You are given an array-like data structure Listy which lacks a size method.It does, however, have an elementAt(i) method that returns the element at index i in 0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data structure only supports positive integers.) Given a Listy which contains sorted, positive integers, find the index at which an element x occurs. If x occurs multiple times, you may return any index.



Given: listy data structure (array w/ values and -1) and element x

listy = [0,3,4,4,5,5,5,5,8,9,-1,-1], x = 4
Assumptions:
    - when x occurs more than 1x, return index

Binary search (modified?):
    [0,3,4,4,5,5,5,5,8,9,-1,-1]
                 ^   4 < 5 go left
    [0,3,4,4,5,5,5,5,8,9,-1,-1]
           ^   4 == 4 check left or right. If true, return index. else -1
               if el is -1, return -1
"


def sorted_search(listy,x,left,right)
  if listy.nil? || listy.length == 0 || left >= right
    return -1
  end
  while left < right
    mid = (left + right) / 2
    if listy[mid] == -1
      break
    end
    if listy[mid] == x
      return mid if (mid+1) < listy.length && listy[mid + 1]
      return mid if (mid-1) >= 0 && listy[mid - 1]
      return -1
    end
    right = mid if listy[mid] > x
    left = mid + 1 if listy[mid] < x
  end
  return -1
end

listy = [0,3,4,4,5,5,5,5,8,9,-1,-1]
x = 5
print(sorted_search(listy,x,0,listy.length))
