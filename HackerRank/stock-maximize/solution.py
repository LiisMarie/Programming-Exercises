#!/bin/python3


def stockmax(prices):
    n = len(prices)  # save for future reference
    answer = 0    # for storing the answer
    local_max = prices[n - 1] # save the last value as current max

    for i in range(n - 2, -1, -1): # go through the remaining of prices in reverse order
        price = prices[i]
        if price < local_max:
            # if local max is bigger than current price then add it to the answer and subtract price
            answer += local_max - price
        else:
            # otherwise save current price as local max
            local_max = price

    return answer


if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        prices = list(map(int, input().rstrip().split()))

        result = stockmax(prices)

        print(str(result))
