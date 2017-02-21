"Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to each other.

['abc','bacd','abc',bacd'] => ['abc','abc',bacd','bacd']

sort by the string length

time: O(n log n)
space: O(1)
"

def group_anagrams(a)
  a.sort!
  a = a.sort_by { |x| x.length }
  return a
end


input = ['zxy','zxyz','abc','bacd','abc','xyz','bacd','zxy','abc','cdfed']

print(group_anagrams(input))
