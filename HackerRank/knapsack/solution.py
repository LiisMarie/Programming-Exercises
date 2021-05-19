#!/bin/python3

def unboundedKnapsack(k, arr):
    # we can use one weight multiple times
    weights = arr  # weights match array

    # create dynamic programming table (for storing previous calculations) based on following sizes
    x_size = k + 1
    y_size = len(weights) + 1
    dp_table = [[0 for _ in range(x_size)] for _ in range(y_size)]

    for i in range(1, y_size):  # get specific row
        for j in range(1, x_size):  # go through that row
            if weights[i - 1] <= j:
                dp_table[i][j] = max(arr[i - 1] + dp_table[i][j - weights[i - 1]], dp_table[i - 1][j])
            elif weights[i - 1] > j:
                dp_table[i][j] = dp_table[i - 1][j]

    return dp_table[-1][-1]


if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):

        nk = input().split()

        n = int(nk[0])

        k = int(nk[1])

        arr = list(map(int, input().rstrip().split()))

        result = unboundedKnapsack(k, arr)

        print(str(result))
