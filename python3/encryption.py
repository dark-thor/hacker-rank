#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the encryption function below.
def encryption(s):
    l = len(s)
    rows = math.floor(math.sqrt(l))
    cols = math.ceil(math.sqrt(l))
    if rows * cols < l:
        rows += 1
    words = []
    for c in range(0, cols):
        word = []
        for r in range(0, rows):
            if r*cols+c < l:
                word.append(s[r*cols+c])
        words.append("".join(word))
    return " ".join(words)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = encryption(s)

    fptr.write(result + '\n')

    fptr.close()

