#!/bin/python3

import math
import os
import random
import re
import sys

def iskaprekarNumber(p):
    s = p*p
    sq = str(s)
    l = int(len(sq)/2)
    if l == 0:
        left = 0
    else:
        left = int(sq[:l])
    right = int(sq[l:])
    if left + right == p:
        return True
    return False

# Complete the kaprekarNumbers function below.
def kaprekarNumbers(p, q):
    r = []
    for x in range(p,q+1):
        if iskaprekarNumber(x):
            r.append(str(x))
    if not r:
        print("INVALID RANGE")
    else:
        print(" ".join(r))

if __name__ == '__main__':
    p = int(input())

    q = int(input())

    kaprekarNumbers(p, q)

