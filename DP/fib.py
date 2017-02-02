
# inefficient...bad!
def fib(n):
    if n <= 2:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)


# better
def fib(n):
    fibValues = [0,1]
    for i in range(2, n + 1):
        fibValues.append(fibValues[i-1] + fibValues[i-2])
    return fibValues[n]
