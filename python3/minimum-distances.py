#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumDistances function below.
def minimumDistances(a):
    m = {}
    result = len(a)
    for i in range(0, len(a)):
        if a[i] in m:
            if result > abs(i - m.get(a[i])):
                result = abs(i - m.get(a[i]))
        m[a[i]] = i
    if result == len(a):
        return -1
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    a = list(map(int, input().rstrip().split()))

    result = minimumDistances(a)

    fptr.write(str(result) + '\n')

    fptr.close()

