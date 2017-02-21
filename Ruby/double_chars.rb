"

"
def double_char(str)
  result = ""
  for c in str.split('')
    result.concat(c)
    result.concat(c)
  end
  return result
end

def double_char(str)
  str.chars.map { |x| x * 2  }.join
end
