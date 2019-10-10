#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c, start):
    if start >= len(c) - 1:
        return 0
    if c[start] == 1: # in air, so land on next one
        return jumpingOnClouds(c, start + 1) + 1
    if c[start+1] == 1: # next is hurdle, must jump
        return jumpingOnClouds(c, start + 2) + 1
    # adjacent zeros, jump 2 spaces. it's OK to land out of bounds.
    return jumpingOnClouds(c, start + 2) + 1

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c, 0)

    fptr.write(str(result) + '\n')

    fptr.close()

