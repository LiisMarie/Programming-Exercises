#!/bin/python3


def solve(points):
    axis_points = [[], [], []]

    for line in points:
        axis_points[0].append(line[0])
        axis_points[1].append(line[1])
        axis_points[2].append(line[2])

    axis_points[0].sort()
    axis_points[1].sort()
    axis_points[2].sort()

    if axis_points[0][3] - axis_points[0][0] == 0 or axis_points[1][3] - axis_points[1][0] == 0 or axis_points[2][3] - axis_points[2][0] == 0:
        return "YES"

    return "NO"


if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        points = []

        for _ in range(4):
            points.append(list(map(int, input().rstrip().split())))

        result = solve(points)

        print(result)
