#!/bin/python3

import math
import os
import random
import re
import sys

def acmTeam(topic, m):
    count_map = {}
    maximum = 0
    for i in range(0, len(topic) - 1):
        for j in range(i+1, len(topic)):
            count = 0
            for x, y in zip(topic[i], topic[j]):
                if x=='1' or y=='1':
                    count += 1
            maximum = max(maximum, count)
            count_map[count] = count_map.get(count, 0) + 1
    return [maximum, count_map.get(maximum)]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    topic = []

    for _ in range(n):
        topic_item = input()
        topic.append(topic_item)

    result = acmTeam(topic, m)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()

