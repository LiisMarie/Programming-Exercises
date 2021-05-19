isIncreasing = False
isNeither = False

amountOfNames = int(input())
word1 = input()
word2 = input()

if word1 < word2:
    isIncreasing = True

for _ in range(amountOfNames - 2):
    word1 = word2
    word2 = input()

    if (word1 > word2 and isIncreasing) or (word1 < word2 and not isIncreasing):
        isNeither = True
        print("NEITHER")
        break

if not isNeither:
    if isIncreasing:
        print("INCREASING")
    else:
        print("DECREASING")
