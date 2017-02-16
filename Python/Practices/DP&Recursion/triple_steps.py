import time
"""
Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
Implement a method to count how many possible ways the child can run up the stairs.

total steps: n
possible ways: 1, 2, 3

"""
def triple_step(n):
    # base case: return 1 when n becomes 0 and return 0 when n becomes less than zero
    if n == 0:
        return 1
    elif n < 0:
        return 0
    # recurse by subtracting in three ways and add up.
    return triple_step(n-1) + triple_step(n-2) + triple_step(n-3)
# time complexity of this algorithm is O(3^n) and space is also O(3^n)

# Some of the resuls are overlapping
"""
overlapping subproblems

                    (5)
            (4)     (2)  (1)
         (3)(2)(1)   ^    ^
             ^      0+1+(1)
                         ^
"""

def triple_step_dp(n, m):
    # base case: return 1...
    if n == 0:
        return 1
    elif n < 0:
        return 0
    # check if the n is already memoized or not
    if m[n] > -1:
        return m[n]
    # recurse in three ways and store them into the m list
    m[n] = triple_step_dp(n-1,m) + triple_step_dp(n-2,m) + triple_step_dp(n-3,m)
    return m[n]
if __name__ == '__main__':

    n = 10
    # recurisive
    start_time = time.time()
    print(triple_step(n))
    print("--- %s seconds ---" % (time.time() - start_time))
    # recurisive + dp
    dp = list(-1 for x in range(n+1))
    start_time = time.time()
    print(triple_step_dp(n,dp))
    print("--- %s seconds ---" % (time.time() - start_time))
