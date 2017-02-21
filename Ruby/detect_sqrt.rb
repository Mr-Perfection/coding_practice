

def is_square(x)
  return false if x < 0
  y = Math.sqrt(x).to_i
  return y * y == x
end

def is_square(x)
  x < 0 ? false : Math.sqrt(x) % 1 == 0
end

def is_square(x)
  return false if x < 0
  (x**0.5) % 1 == 0
end
