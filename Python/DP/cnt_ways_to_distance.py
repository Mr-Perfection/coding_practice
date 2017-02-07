"""
Count number of ways to cover a distance
Input:  n = 3
Output: 4
Below are the four ways
 1 step + 1 step + 1 step
 1 step + 2 step
 2 step + 1 step
 3 step

Input:  n = 4
4 step
3 step + 1 step
2 step + 2 step
2 step + 1 step + 1 step
1 step + 3 step
1 step + 2 step + 1 step
1 step + 1 step + 1 step + 1 step

Output: 7
                4
            3       1+(3)
        2       1+(2)
    1

"""
import time

# assumed steps can be ranging from 1...n
# def distance(n):
#     if n == 0:
#         return 1
#     if n < 0:
#         return 0
#     steps = 0
#     for i in range(1,n+1):
#         steps+=distance(n-i)
#     print(steps)
#     return steps

#O(3^n)
def distance(n):
    if n == 0:
        return 1
    if n < 0:
        return 0

    return distance(n-1)+distance(n-2)+distance(n-3)

#O(n),O(n)
def distance_m(n,m):
    if n == 0:
        return 1
    if n < 0:
        return 0
    if m[n] > 0:
        return m[n]
    m[n] = distance(n-1)+distance(n-2)+distance(n-3)
    return m[n]
# time
# Driver program to test the functions above
def main():
    n = 4
    m = [0]*(n+1)
    start_time = time.time()
    print(distance(n))
    print("--- %s seconds ---" % (time.time() - start_time))
    start_time = time.time()
    print(distance_m(n,m))
    print("--- %s seconds ---" % (time.time() - start_time))

if __name__=="__main__":
    main()
