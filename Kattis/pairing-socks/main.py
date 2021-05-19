from collections import deque

amountOfPairs = int(input())
initialPile = deque(map(int, input().split()))

temporaryPile = deque()

moves = 0
while True:
    if temporaryPile and initialPile:
        if temporaryPile[0] == initialPile[0]:
            temporaryPile.popleft()
            initialPile.popleft()
        else:
            temporaryPile.appendleft(initialPile.popleft())
    elif temporaryPile:
        print("impossible")
        break
    elif initialPile:
        temporaryPile.appendleft(initialPile.popleft())
    else:
        print(str(moves))
        break
    moves += 1
