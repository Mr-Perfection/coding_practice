'''
Coins: Given an innnite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
pennies (1 cent), write code to calculate the number of ways of representing n cents.

Using recursion

f(n)
f(n) = f(n - 25) + f(n - 10) + f(n - 5) + f(n-1)

Overlapping subproblems exist.
Use DP.
'''

dimport time
def coins_test(n,coins):
    if n == 0:
        return 1
    elif n < 0:
        return 0
    result = 0
    for coin in coins:
        result += coins_test(n-coin,coins)
    return result


def coins_dp(n, coins):
    # check is coins is None or n is zero
    if not(coins) or len(coins) == 0 or n == 0:
        return 0
    # initializaitons
    # mem = [n + 1]
    mem = [[ -1 for j in range(len(coins))] for i in range(n+1)]
    # return the helper(n, coins, mem)
    return coins_dp_helper(n, coins, mem)

def coins_dp_helper(n, coins, mem):
    # base case: n is 0, return 1
    # base case 2: n is negative, return 0
    if n == 0:
        return 1
    elif n < 0:
        return 0

    # initializaitons
    result = 0
    # iterate through all the possible coins
    for i in range(len(coins)):
        if mem[n][i] == -1:
            mem[n][i] = coins_dp_helper(n - coins[i], coins, mem)
        result += mem[n][i]
    # store result into mem[n]
    #print(result)
    return result


coins = [1,5,10,25]
n = 50
start_time = time.time()
print(coins_dp(n,coins))
print("--- %s seconds ---" % (time.time() - start_time))
print('-------')
start_time = time.time()
print(coins_test(n,coins))
print("--- %s seconds ---" % (time.time() - start_time))


"""
Interestingly, with a smaller data set, coins_test function runs slightly faster but as the n increases, the coins_dp is MUCH FASTER than coins_test
""""





#!/bin/python3

import sys

def make_change(coins, n,index,table):
    # base case: n < 0, return 0
    if n < 0:
        return 0
    # base case: n == 0, return 1
    if n == 0:
        return 1
    if table[n][index] > 0:
        return table[n][index]
    # for i...coins length
    for i in range(index,len(coins)):
        # result += make_change(coins, n-coins[i])
        if n - coins[i] < 0:
            continue
        if table[n-coins[i]][i] != 0:
            table[n][index] += table[n-coins[i]][i]
        else:
            table[n][index] += make_change(coins,n-coins[i],i,table)
    return table[n][index]

n,m = input().strip().split(' ')
n,m = [int(n),int(m)]
table = [[0 for j in range(m)] for i in range(n+1)]
coins = [int(coins_temp) for coins_temp in input().strip().split(' ')]
print(make_change(coins, n,0,table))
