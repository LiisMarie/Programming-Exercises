#!/bin/python3


def summingPieces(integer_array):
    mod = 10 ** 9 + 7
    total_value = q = t = 0
    t_2 = z = 1

    for integer in integer_array:
        total_value = (2 * total_value + t_2 * integer + q) % mod
        q = (q + z * integer) % mod
        t = 1 if t == 0 else (t * 2) % mod
        z = (z + t) % mod
        t_2 = (t_2 + z) % mod
    return total_value


if __name__ == '__main__':
    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = summingPieces(arr)

    print(str(result))
