#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the birthdayCakeCandles function below.
def birthdayCakeCandles(arr):
    count = 0
    maximum = 0
    for i in range(0, len(arr)):
        if maximum == arr[i]:
            count += 1
        elif maximum < arr[i]:
            count = 1
            maximum = arr[i]
    return count

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    ar_count = int(input())

    ar = list(map(int, input().rstrip().split()))

    result = birthdayCakeCandles(ar)

    fptr.write(str(result) + '\n')

    fptr.close()

