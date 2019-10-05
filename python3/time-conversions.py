#!/bin/python3

import os
import sys

#
# Complete the timeConversion function below.
#
def timeConversion(s):
    #
    # Write your code here.
    #
    tail = s[-2:]
    hour = int(s[0:2])
    if tail == 'PM' and hour != 12:
        hour += 12
    elif tail == 'AM' and hour == 12:
        hour = 0
    if hour < 10:
        return '0'+str(hour)+s[2:-2]
    else:
        return str(hour)+s[2:-2]

if __name__ == '__main__':
    f = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    f.write(result + '\n')

    f.close()

