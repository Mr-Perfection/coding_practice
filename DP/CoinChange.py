# https://interactivepython.org/runestone/static/pythonds/Recursion/DynamicProgramming.html

"""
Suppose you are a programmer for a vending machine manufacturer.
Your company wants to streamline effort by giving out the fewest possible coins
in change for each transaction. Suppose a customer puts in a dollar bill and purchases an item
for 37 cents. What is the smallest number of coins you can use to make change?
quarter, dime, penny
Greedy approach
break down the problem into subproblems
37 - 25 = 12 // 1 quarter
12 - 10 = 2 // 2 dimes
2 - 2 = 0 // 2 cents


""""
def minCoins(coinsList, change):
    min = 0
    if change in coinsList:
        return 1
    for i in [c for c in coinsList if c <= change]:
        numCoins  = 1 + minCoins(coinsList, change - i)
        min = numCoins
    return min

"""
You can definitley make it more efficient by using memoization
"""
def minCoinsMemo(coinsList, change, cache):
    min = 0
    if change in coinsList:
        return 1
    if cache[change] > 0:
        return cache[change]
    for coin in [coins for c in coinsList if c <= change]:
        cache[change] = 1 + minCoinsMemo(coinsList, change - coin, cache)
        min = cache[change]
    return min

"""
dpMakeChange takes three parameters: a list of valid coin values, the amount of change
we want to make, and a list of the minimum number of coins needed to make each value.
When the function is done minCoins will contain the solution for all values from 0 to
the value of change.
"""
def dpMakeChange(coinsList, change, minCoins):
    # iterate from 0 to change
    for cents in range(change + 1):
        coinCount = 0
        # iterate through coinsList
        for j in [c for c in coinsList if c <= cents]:
            coinCount = minCoins[cents-j] + 1
        minCoins[cents] = coinCount

    return minCoins[change]


def dbMakeChange(coinValueList, change, minCoins, coinsUsed):
    for cents in (change + 1):
        coinCount = 0
        coinUsed = 0
        for j in [coins for c in coinValueList if c <= change]:
            coinCount = minCoins[cents-j] + 1
            coinUsed = j
        minCoins[cents] = coinCount
        coinsUsed[cents] = newCoin
    return minCoins[change]

def main():
    amount  = 63
    coinsList = [1, 5, 10, 25]
    coinsUsed = (amount + 1) * [0]
    coinCount = (amount + 1) * [0]
    print("Making change for",amnt,"requires")
    print(dpMakeChange(clist,amnt,coinCount,coinsUsed),"coins")
    print("They are:")
    printCoins(coinsUsed,amnt)
    print("The used list is as follows:")
    print(coinsUsed)



"""
    base case:
        numCoins = min(1 + numCoins(original amount - 1),
                       1 + numCoins(original amount - 5),
                       1 + numCoins(original amount - 10),
                       1 + numCoins(original amount - 25))

"""
def recMC(coinValueList, change):
    minCoins = change
    if change in coinValueList:
        return 1
    else:
        for i in [c for c in coinValueList if c <= change]:
            numCoins = 1 + recMC(coinValueList, change - i)
            if numCoins < minCoins:
                minCoins = numCoins
    return minCoins

"""
VERY inefficient is above algorithm.
Can be optimized by using memoization

""""
def recDC(coinValueList, change, knownResults):
    minCoins = change
    if change in coinValueList:
        knownResults[change] = 1
    elif knownResults[change] > 0:
        return knownResults[change]
    else:
        for i in [c for c in coinValueList if c <= change]:
            minCoins = 1 + recDC(coinValueList, change - i, knownResults)
            knownResults[change] = minCoins
    return minCoins
