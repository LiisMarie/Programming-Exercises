#!/bin/python3


def getWays(n, c):
    answers_list = [0] * (n + 1)   # make an array size of desired amount+1  and fill it with zeros
    answers_list[0] = 1  # first has to be 1
    for coin in c:  # go through given coins
        for i in range(coin, len(answers_list)):
            answers_list[i] += answers_list[i - coin]  # calculate new values
    return answers_list[n]


if __name__ == '__main__':
    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    m = int(first_multiple_input[1])

    c = list(map(int, input().rstrip().split()))

    # Print the number of ways of making change for 'n' units using coins having the values given by 'c'

    ways = getWays(n, c)

    print(str(ways))
