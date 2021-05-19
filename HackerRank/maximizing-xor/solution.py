#!/bin/python3


def maximizingXor(l, r):
    maximum = 0
    for x in range(l, r + 1):  # start from l
        for y in range(x, r + 1):  # go from x to r
            maximum = max(maximum, x ^ y)  # find maximum from values using pythons XOR(^) operator
    return maximum


if __name__ == '__main__':
    l = int(input())

    r = int(input())

    result = maximizingXor(l, r)

    print(str(result))
