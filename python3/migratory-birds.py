#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the migratoryBirds function below.
def migratoryBirds(arr):
    m = {}
    bird = arr[0]
    count = 0
    for b in arr:
        m[b] = m.get(b,0)+1
        if m.get(b) > count:
            count = m.get(b)
            bird = b
        if m.get(b) == count and b < bird:
            bird = b
    return bird

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = migratoryBirds(arr)

    fptr.write(str(result) + '\n')

    fptr.close()

