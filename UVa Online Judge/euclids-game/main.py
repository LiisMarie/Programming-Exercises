def get_winner(n, m):
    # based on slide 23
    # https://numbertheoryguydotcom.files.wordpress.com/2018/01/10-number-theory-games-student.pdf
    division = n / m
    if division == 1 or division > 1.618033988749895:
        print("Stan wins")
    else:
        print("Ollie wins")


if __name__ == '__main__':
    while True:
        testCase = input().split(" ")
        a = int(testCase[0])
        b = int(testCase[1])
        if a == 0 and b == 0:
            break
        get_winner(max(a, b), min(a, b))
