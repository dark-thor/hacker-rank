#!/bin/python3

import math
import os
import random
import re
import sys

def utopianTree(n):
    h = 1
    for x in range(0, n):
        if (x % 2 == 0):
            h = h * 2
        else:
            h = h + 1
    return h

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        n = int(input())

        result = utopianTree(n)

        fptr.write(str(result) + '\n')

    fptr.close()

