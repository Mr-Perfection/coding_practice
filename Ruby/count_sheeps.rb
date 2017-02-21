"
escription:

Consider an array of sheep where some sheep may be missing from their place. We need a function that counts the number of sheep present in the array (true means present).

For example,

The correct answer would be 17.

Hint: Don't forget to check for bad values like null/undefined

"

def countSheeps array
  cnt = 0
  for i in (0...array.length)
    unless array[i].nil? || array[i] == false
      cnt += 1
    end
  end
  return cnt
end

# Simple solution...
def countSheeps(array)
  array.count(true)
end
