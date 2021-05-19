import math


def round_half_up(n, decimals=0):
    multiplier = 10 ** decimals
    return math.floor(n * multiplier + 0.5) / multiplier


cases = int(input())

for _ in range(cases):
    rate, balance, monthly = tuple(map(float, input().split(" ")))

    balance = int(round_half_up(balance * 100))
    monthly = int(round_half_up(monthly * 100))

    multiplier = 1 + rate / 100
    months = 0
    while balance > 0 and months <= 1200:
        balance *= multiplier
        balance = round_half_up(balance)
        balance -= monthly
        balance = round_half_up(balance)
        months += 1
    if months == 1201:
        print("impossible")
    else:
        print(months)
