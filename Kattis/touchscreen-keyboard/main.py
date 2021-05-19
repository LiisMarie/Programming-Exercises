keyboard = [
    ["q", "w", "e", "r", "t", "y", "u", "i", "o", "p"],
    ["a", "s", "d", "f", "g", "h", "j", "k", "l"],
    ["z", "x", "c", "v", "b", "n", "m"]
]


def find(char):
    x_ = 0
    while x_ < len(keyboard):
        y_ = 0
        while y_ < len(keyboard[x_]):
            if char == keyboard[x_][y_]:
                return [x_, y_]
            y_ += 1
        x_ += 1


if __name__ == '__main__':
    testCases = int(input())

    while testCases > 0:
        testCases -= 1
        firstLine = input().split(" ")

        typedWord = firstLine[0]
        wordsAmount = int(firstLine[1])

        wordsList = []
        while wordsAmount > 0:
            word = str(input())
            distance = 0
            i = 0
            while i < len(word):
                x, y = find(word[i])
                X, Y = find(typedWord[i])
                distance += abs(x - X) + abs(y - Y)
                i += 1
            wordsList.append([word, distance])
            wordsAmount -= 1

        wordsList = sorted(wordsList, key=lambda word_to_compare: word_to_compare[0])
        wordsList = sorted(wordsList, key=lambda word_to_compare: word_to_compare[1])

        for word in wordsList:
            print(word[0] + " " + str(word[1]))
