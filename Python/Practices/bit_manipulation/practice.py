bits = []
val = 190
while val > 0:
  bits.append(val & 1)
  val = int(val / 2)
print(bits)

# find the longest length of bits of 1s with one flip or None
lens = []
count = 0

if len(bits) == 1:
  print(bits[0])

for bit in bits:
  if bit:
    count += 1
  else:
    lens.append(count)
    lens.append(bit)
    count = 0
if count:
  lens.append(count)
print(lens)
ret = 1
for i in range(len(lens)):
  l = lens[i]
  if l:
    ret = max(ret,l)
  else:
    if  0 < i < len(lens)-1:
      if not(lens[i]) and lens[i-1] and lens[i+1]:
        ret = max(lens[i-1]+lens[i+1]+1,ret)
print(ret)
