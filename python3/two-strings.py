#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the twoStrings function below.
def twoStrings(s1, s2):
    s = {}
    for c in s1:
        s[c] = 1
    for c in s2:
        if 1 == s.get(c,0):
            return "YES"
    return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s1 = input()

        s2 = input()

        result = twoStrings(s1, s2)

        fptr.write(result + '\n')

    fptr.close()

