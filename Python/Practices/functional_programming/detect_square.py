def is_square(n):
    if n < 0:
        return False
    y = int(n**(1/2))
    if y * y == n:
        return True
    return False
def is_square(n):
    return n > 0 and n**(0.5).is_integer()
