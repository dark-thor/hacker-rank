#!/bin/python3

def staircase(n):
    s = list(''.rjust(n, ' '))
    for i in range(1,n+1):
        s[n-i] = '#'
        print("".join(s))

if __name__ == '__main__':
    n = int(input())

    staircase(n)

