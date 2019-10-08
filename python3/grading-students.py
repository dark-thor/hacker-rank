#!/bin/python3

import math
import os
import random
import re
import sys

def gradingStudents(grades):
    results = []
    for g in grades:
        if g < 38:
            results.append(g)
        elif g%5 >= 3:
            results.append(int((g/5)+1)*5)
        else:
            results.append(g)
    return results

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    grades_count = int(input().strip())

    grades = []

    for _ in range(grades_count):
        grades_item = int(input().strip())
        grades.append(grades_item)

    result = gradingStudents(grades)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()

