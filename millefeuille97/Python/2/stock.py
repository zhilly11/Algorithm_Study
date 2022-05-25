# 백준 11501번

T = int(input())

for i in range(T):
    N = int(input())
    stock = list(map(int, input().split()))
    result = 0
    large = 0

    for x in reversed(stock):
        if large > x:
            result += (large - x)
        else:
            large = x
    print(result)