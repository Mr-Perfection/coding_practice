#!/bin/python

import sys


a,b,c,d,e = input().strip().split(' ')
arr = [int(a),int(b),int(c),int(d),int(e)]
arr.sort()
print(str(sum(arr[:-1])),str(sum(arr[1:])))
