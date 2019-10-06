#!/bin/python3

import math
import os
import random
import re
import sys

def pickingNumbers(a):
    m = {}
    for x in a:
        m[x] = m.get(x, 0) + 1

    result = 1
    for x in a:
        y = m.get(x, 0) + m.get(x+1, 0)
        if y > result:
            result = y
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    result = pickingNumbers(a)

    fptr.write(str(result) + '\n')

    fptr.close()

