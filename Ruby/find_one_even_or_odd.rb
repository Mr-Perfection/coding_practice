def find_outlier(integers)
  table = integers.group_by {|x| x % 2}
  return table[0].length > table[1].length ? table[1].first : table[0].first
end

def find_outlier(integers)
  integers.partition(&:odd?).find(&:one?).first
end
