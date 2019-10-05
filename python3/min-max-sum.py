#!/bin/python3

import math

def miniMaxSum(arr):
    minimum = arr[0]
    maximum = arr[0]
    total = arr[0]
    for i in range(1, len(arr)):
        minimum = min(minimum, arr[i])
        maximum = max(maximum, arr[i])
        total += arr[i]
    print(str(total-maximum)+" "+str(total-minimum))

if __name__ == '__main__':
    arr = list(map(int, input().rstrip().split()))

    miniMaxSum(arr)

