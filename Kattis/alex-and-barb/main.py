cards_amount, m, n = map(int, input().split(" "))
if cards_amount % (m + n) < m:
    # barb was the last one to get m-n cards so he wins
    print("Barb")
else:
    print("Alex")
