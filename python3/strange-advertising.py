#!/bin/python3

import math
import os
import random
import re
import sys

def viralAdvertising(n):
    count = 0
    people = 5
    for x in range(0, n):
        liked = math.floor(people/2)
        count += liked
        people = liked * 3
    return count

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    result = viralAdvertising(n)

    fptr.write(str(result) + '\n')

    fptr.close()

