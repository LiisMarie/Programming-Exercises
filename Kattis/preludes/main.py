import sys

preludesDict = {
    "A#": "Bb",
    "C#": "Db",
    "D#": "Eb",
    "F#": "Gb",
    "G#": "Ab",
    "Bb": "A#",
    "Db": "C#",
    "Eb": "D#",
    "Gb": "F#",
    "Ab": "G#"
}

counter = 0
for userInput in sys.stdin:
    counter += 1
    strArr = userInput.split()

    newName = preludesDict.get(strArr[0], None)
    if newName is not None:
        print("Case " + str(counter) + ": " + newName + " " + strArr[1])
    else:
        print("Case " + str(counter) + ": UNIQUE")
