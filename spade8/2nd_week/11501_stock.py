
import sys
input = sys.stdin.readline

testcase_num = int(input().strip())

for i in range(testcase_num):
    num = int(input().strip())

    price= list(map(int, input().strip().split()))
    profit = 0
    max =price[-1]
    for i in range(num-2,-1,-1):
        if max < price[i]:
            max = price[i]
        else:
            profit += (max - price[i])
    print(profit)



