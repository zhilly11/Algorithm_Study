# 백준 2457번

from sys import stdin

N = int(stdin.readline())
flower = []

for i in range(N):
    startMonth, startDay, endMonth, endDay = map(int, stdin.readline().split())
    if 100 * endMonth + endDay < 301 or 100 * startMonth + startDay > 1130:
        continue    # 시작날짜가 11월 30일을 넘어가거나 끝날짜가 3월 1일 아래면 넘어간다.
    flower.append([100 * startMonth + startDay, 100 * endMonth + endDay])

day = 301
flower.sort()
idx = 0
count = 0
next = 0

while day <= 1130:
    for i in range(idx, N):
        if flower[i][0] > day:      # 시작날짜보다 크면 안된다. ex 첫 날짜는 3월 1일부터 작아야됨
            break
        if flower[i][1] > next:    # 원래 꽃의 지는 날이 현재 꽃의 지는 날보다 늦는 경우
            next = flower[i][1]
            idx = i

    if next == 0:
        print(0)
        exit()   # 만족도 못하면 그냥 탈출

    if day == next:
        print(0)
        exit()  # day가 12월 1일까지 도달하지 못한 경우
    day = next
    count += 1

print(count)

