# https://interactivepython.org/runestone/static/pythonds/Recursion/DynamicProgramming.html

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
