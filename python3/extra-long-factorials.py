#!/bin/python3

# python numbers are unbounded.
def extraLongFactorials(n):
    result = 1
    for i in range(1, n):
        result += result*i
    print(result)

if __name__ == '__main__':
    n = int(input())

    extraLongFactorials(n)

