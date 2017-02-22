import math
def dig_pow(n, p):
    nums = list(str(n))
    result = sum([int(nums[i])**(i + p) for i in range(len(nums))])
    return int(result / n) if (result / n).is_integer() else -1
