#!/bin/python3
# https://www.hackerrank.com/challenges/staircase
import sys


n = int(input().strip())
for i in range(n):
    print( ' '*(n-1-i) + '#'*(i+1))
