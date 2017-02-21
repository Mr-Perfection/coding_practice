require 'benchmark'


def duplicate_count(text)
  cnt, s = 0, {}
  for c in text.downcase.split('')
    if s.has_key?(c)
      if s[c] == 1
        cnt += 1
      end
      s[c] += 1
    else
      s[c] = 1
    end
  end
  return cnt
end
# time: O(n)
# space: O(n)

def duplicate_count2(text)
  ('a'..'z').count { |c| text.downcase.count(c) > 1}
end
# time: O(n^2)
# space: O(n)

input = "Indivisibilitiesasdfashdjklajshfljashjfklhaskldfljkhalhsfafdsljfkahsfkhasjfklhdsjdkhflakjh"

# start = Time.now
# puts duplicate_count2(input)
# finish = Time.now
# puts finish-start

# start2 = Time.now
# puts duplicate_count(input)
# finish2 = Time.now
# puts finish2-start2


Benchmark.bm do |x|
  x.report { duplicate_count2(input) }
  x.report { duplicate_count(input) }
end
