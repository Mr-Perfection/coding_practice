def series_sum(n):
    if n == 0:
        return "0.00"
    return "%.2f" % sum([1 / (x * 3 + 1) for x in range(n)])
