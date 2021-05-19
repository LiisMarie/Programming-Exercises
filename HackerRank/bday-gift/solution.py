#!/bin/python3


def solve(balls):
    amount = 0.0
    for nr in balls:
        amount += nr / 2.0
    return amount


if __name__ == '__main__':
    balls_count = int(input())

    balls = []

    for _ in range(balls_count):
        balls_item = int(input())
        balls.append(balls_item)

    result = solve(balls)

    print(str(result) + '\n')
