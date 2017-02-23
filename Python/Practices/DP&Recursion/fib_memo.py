def fibonacci(n):
    if n in [0, 1]:
        return n
    memo = {}
    return fibonacci_helper(n,memo)

def fibonacci_helper(n,memo):
    if n in [0,1]:
        return n
    if n in memo:
        return memo[n]
    memo[n] = fibonacci_helper(n-1, memo) + fibonacci_helper(n-2, memo)
    return memo[n]
