# return the length of a shortest word

def find_short(s)
  s.split(' ').map(&:length).min
end

def find_short(s)
  ws = s.split(' ')
  l = ws[0].length
  for w in ws
    l = [l,w.length].min
  end
  return l # l: length of the shortest word
end
