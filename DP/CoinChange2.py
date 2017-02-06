# www.hackerrank.com/challenges/coin-change
import sys
# print(sys.stdin.read())
# greedy algorithm
def coinChange(index, coinValues, change, cache):
    if change == 0:
        return 1
    if change < 0:
        return 0
    if index >= len(coinValues):
        return 0
    if cache[index][change] > 0:
        return cache[index][change]
    cache[index][change] = coinChange(index, coinValues, change - coinValues[index], cache) + coinChange(index + 1,coinValues, change, cache)
    return cache[index][change]

rawString = sys.stdin.read()

"""inputs based on line"""
lines = rawString.split('\n')

"""seperate lines and dictionary"""
row1 = lines[0].split(' ')

row2 = [int(val) for val in lines[1].split(' ')]
memo = [[0]*(int(row1[0]) + 1) for i in range(len(row2))]

dict = [0] * (int(row1[0]) + 1)
"""insert into coinChange function"""
#print(row2)
print(coinChange(0,row2, int(row1[0]), memo))
#print(dict)
