"""
O(n) one liner
"""

def is_prime(num):
    return num > 1 and all(num % x != 0 for x in range(2,num))

def is_prime(num):
    return num > 1 and not any(num % x == 0 for x in range(2,num))
num = 5
print(is_prime(num))
