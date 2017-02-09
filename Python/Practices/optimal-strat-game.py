"""
Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even.
We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row,
removes it from the row permanently, and receives the value of the coin.
Determine the maximum possible amount of money we can definitely win if we move first.

given hints: [8, 15, 3, 7], 4

best move for user:
n=4
user: n=3, [7], [8,15,3]
player: n=0, [7], [15,3]
user: n=0, [7,15], [3]

Approach:
if user picks [0], then opponent has two possible moves: [1] or [n-1] (user takes minimum of [2] or [n-2])
if user picks [n-1], then opponent has two possible moves: [0] or [n-2] (user takes minimum of [1] or [n-3])

-Assume n is the length of coins
result = max(Ci + min([1],[n-1]), Cn-1 + min([0],[n-1]))

F(arr) represents the maximum value the user can collect from
         array of coins
         F(arr) = max(arr[0] + min(F(arr[2:]),F(arr[1:n-1]), arr[n-1] + min(F(arr[1:n-1]),F(arr[0:n-2])))


F(i, j)  represents the maximum value the user can collect from
         i'th coin to j'th coin.

    F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ),
                   Vj + min(F(i+1, j-1), F(i, j-2) ))
Base Cases
    F(i, j)  = Vi           If j == i
    F(i, j)  = max(Vi, Vj)  If j == i+1

reference
http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/

"""

import time
# O(2^n)
def game(coins):
    n = len(coins)
    if n == 2:
        return max(coins[0], coins[n-1])
    # print(n)
    return max(coins[0] + min(game(coins[2:]),game(coins[1:n-1])),
                coins[n-1] + min(game(coins[1:n-1]),game(coins[0:n-2])))


# O(n^2)
def game_dp(coins,dp,i,j):
    n = len(coins)
    if j == i+1:
        return max(coins[i], coins[j])
    if dp[i][j] > -1:
        return dp[i][j]
    # print(dp[i][j])
    dp[i][j] = max(coins[i] + min(game_dp(coins,dp,i+1,j-1),game_dp(coins,dp,i+2,j)), coins[j] + min(game_dp(coins,dp,i,j-2),game_dp(coins,dp,i+1,j-1)))
    return dp[i][j]



print(game([8, 15, 3, 7])) #22
print(game([2, 2, 2, 2])) #4

print("-------------------")
coins = [20, 30, 2, 2, 2, 10]
# coins = [2, 2, 2, 2]
# coins = [8, 15, 3, 7]
dp = [[-1 for j in range(len(coins))] for i in range(len(coins))]

start_time = time.time()
print(game(coins)) #42
print("--- %s seconds ---" % (time.time() - start_time))
start_time = time.time()
print(game_dp(coins,dp,0,len(coins)-1)) #42
print("--- %s seconds ---" % (time.time() - start_time))
