#!/bin/python3


def boardCutting(cost_y, cost_x):
    cost_y.sort()
    cost_x.sort()

    y_length = len(cost_y)
    x_length = len(cost_x)

    y_array = cost_y[::-1]
    x_array = cost_x[::-1]

    x_pivot = 0
    y_pivot = 0

    cost = 0
    x_edge_cut = 1
    y_edge_cut = 1

    while x_pivot < y_length and y_pivot < x_length:  # while there are rows and columns to cut
        if y_array[x_pivot] < x_array[y_pivot]:  # when horizontal cost < vertical cost
            cost += x_edge_cut * x_array[y_pivot]  # add cutting cost
            y_edge_cut += 1  # increment y edge cut
            y_pivot += 1  # increment y pivot
        else:
            # when horizontal cost >= vertical cost
            cost += y_edge_cut * y_array[x_pivot]
            x_edge_cut += 1
            x_pivot += 1

    while x_pivot >= y_length and y_pivot < x_length:
        # if there are any, add leftovers of vertical cost
        cost += x_edge_cut * x_array[y_pivot]
        y_edge_cut += 1
        y_pivot += 1

    while x_pivot < y_length and y_pivot >= x_length:
        # if there are any, add leftovers of horizontal cost
        cost += y_edge_cut * y_array[x_pivot]
        x_edge_cut += 1
        x_pivot += 1

    return cost % 1000000007  # return result


if __name__ == '__main__':

    q = int(input())

    for q_itr in range(q):
        mn = input().split()

        m = int(mn[0])

        n = int(mn[1])

        cost_y = list(map(int, input().rstrip().split()))

        cost_x = list(map(int, input().rstrip().split()))

        result = boardCutting(cost_y, cost_x)

        print(str(result))
