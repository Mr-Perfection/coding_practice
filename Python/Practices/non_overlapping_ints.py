"""
Non-overlapping Intervals
Given a collection of intervals, find the minimum number of intervals you need to remove
to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
"""
# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int

        input: [ [1,2], [2,3], [3,4], [1,3] ]
        - create a dictionary that will store d[first] = d[second] first element and second element of interval in intervals
        - loop through all intervals and if there exists a key increments the counter

        """
        d = {}
        cnt = 0
        for i in intervals:
            if i[:1] in d:
                cnt+=1
            else:
                d[i[:1]] = d[i[1:]]
        return cnt
