#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the checkMagazine function below.
def checkMagazine(magazine, note):
    m = {}
    for w in magazine:
        m[w] = m.get(w, 0) + 1
    for w in note:
        c = m.get(w, 0)
        if c == 0:
            print("No")
            return
        m[w] = m.get(w) - 1
    print("Yes")

if __name__ == '__main__':
    mn = input().split()

    m = int(mn[0])

    n = int(mn[1])

    magazine = input().rstrip().split()

    note = input().rstrip().split()

    checkMagazine(magazine, note)

