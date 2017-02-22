def isPrime(num)
  return num > 1 && (2..num-1).all?{ |x| num % x != 0 }
end
