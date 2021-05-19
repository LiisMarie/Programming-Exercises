inputs = input().split()
m = int(inputs[0])
a = int(inputs[1])
b = int(inputs[2])
c = int(inputs[3])

if 2 * m >= a + b + c:
    print("possible")
else:
    print("impossible")
