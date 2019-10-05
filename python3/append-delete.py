#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the appendAndDelete function below.
def appendAndDelete(s, t, k):
    slen = len(s)
    tlen = len(t)
    if k >= slen + tlen:
        return "Yes"
    l = min(slen, tlen)
    for i in range(0, l):
        if s[i] != t[i]:
            break
    diff = slen + tlen - 2*i - k
    # Not enough steps
    if diff > 0:
        return "No"
    if diff%2 == 0:
        return "Yes"
    return "No"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    t = input()

    k = int(input())

    result = appendAndDelete(s, t, k)

    fptr.write(str(result) + '\n')

    fptr.close()

