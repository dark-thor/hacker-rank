#!/bin/python3

import math
import os
import random
import re
import sys

def jumpingOnClouds(c, k):
    e = 100
    i = 0
    while True:
        e -= 1
        if c[(i+k)%n] == 1:
            e -= 2
        i = (i+k)%n
        if i == 0:
            break
    return e

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c, k)

    fptr.write(str(result) + '\n')

    fptr.close()

