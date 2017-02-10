#!/bin/python3
#https://www.hackerrank.com/challenges/library-fine
import sys

d1,m1,y1 = [ int(x) for x in input().strip().split(' ')]
d2,m2,y2 = [ int(x) for x in input().strip().split(' ')]
fine_m = fine_d = 0
# 1) check if it has been a calendar year. If diff > 0 print 10000 hackeros
if y1 > y2:
    print('10000')
elif y1 < y2:
    print('0')
elif m1 > m2:
    print(str((m1-m2)*500))
elif m1 < m2:
    print('0')
elif d1 > d2:
    print(str((d1-d2)*15))
else:
    print('0')
