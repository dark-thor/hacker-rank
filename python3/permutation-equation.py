#!/bin/python3

import math
import os
import random
import re
import sys

def permutationEquation(p):
    result = [0]*len(p)
    for i in range(1, len(p)+1):
        result[p[p[i-1]-1]-1] = i
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    p = list(map(int, input().rstrip().split()))

    result = permutationEquation(p)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()

