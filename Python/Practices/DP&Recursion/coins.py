'''
Coins: Given an innnite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
pennies (1 cent), write code to calculate the number of ways of representing n cents.

Using recursion

f(n)
f(n) = f(n - 25) + f(n - 10) + f(n - 5) + f(n-1)

Overlapping subproblems exist.
Use DP.
'''

def coins_dp(n, coins):
    # check is coins is None or n is zero
    if not(coins) or len(coins) == 0 or n == 0:
        return 0
    # initializaitons
    # mem = [n + 1]
    mem = [ -1 for i in range(n+1)]
    # return the helper(n, coins, mem)
    return coins_dp_helper(n, coins, mem)

def coins_dp_helper(n, coins, mem):
    # base case: n is 0, return 1
    # base case 2: n is negative, return 0
    if n == 0:
        return 1
    elif n < 0:
        return 0
    # if mem[n] is not -1, return mem[n]
    if mem[n] != -1:
        return mem[n]
    # initializaitons
    result = 0
    # iterate through all the possible coins
    for coin in coins:
        result += coins_dp_helper(n - coin, coins, mem)
    # store result into mem[n]
    print(result)
    mem[n] = result
    return result


coins = [1,5,10,25]
n = 10
print(coins_dp(n,coins))
print('-------')
