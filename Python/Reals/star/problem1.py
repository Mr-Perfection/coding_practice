# you can write to stdout for debugging purposes, e.g.
# print "this is a debug message"

def solution(E, L):
    # write your code in Python 2.7
    """
    default fee = 2
    first hour or partial hour fee = 3
    after successive full or patial hour or full = 4

    E 10:00, L 13:21 = 2 + 3 + 4*2 + 4 =17
    """
    # edge cases
    # if E or L is not defined, just default fee
    if not(E) or not(L): return 2

    # initializations
    total = 2
    timeE,timeL = [int(x) for x in E.split(':')],[int(x) for x in L.split(':')]
    diff = []
    hours,mins = 0,0
    # get diff between timeE and timeL
    for i in range(len(timeE)):
        diff.append(timeL[i]-timeE[i])

    # while diff[0] or hours is greater than 0
    hours = diff[0]
    mins = diff[1]

    # edge case: if hours is 0 but mins is > 0, then just return total+3 (first partial mins)
    if hours == 0 and mins > 0: return total+3

    while hours:
        if hours == 1:
            total += 3
        else:
            total += 4
        hours -= 1

    # any partial minutes only counts as $4 as a fee
    if mins > 0:
        total += 4
    return total
