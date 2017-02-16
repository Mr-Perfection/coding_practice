n, m = [int(x) for x in input().split()]
coinValues = [int(x) for x in input().split()]
memo = {}
def coinChange(index, coinValues, change):
    key = (index, change)
    if key in memo:
        return memo[key]
    elif change == 0:
        memo[key] = 1
    elif change < 0 or index >= len(coinValues):
        memo[key] = 0
    else:
        memo[key] = coinChange(index, coinValues, change - coinValues[index]) + coinChange(index + 1,coinValues, change)
    return memo[key]

print(coinChange(0, coinValues, n))