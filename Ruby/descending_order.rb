def descending_order(n)
  return n.to_s.chars.sort{|a,b| b<=>a}.join.to_i
end


def descending_order(n)
  n.to_s.chars.sort.reverse.join.to_i
end
