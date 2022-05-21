# 백준 1744번

from sys import stdin

N = int(stdin.readline())

plus = []   # 양수 리스트
minus = []  # 음수 리스트

result = 0
for i in range(N):
    num = int(stdin.readline())
    if num > 1:
        plus.append(num)
    elif num <= 0:
        minus.append(num)
    else:
        result += num

plus.sort(reverse=True)     # 내림차순
minus.sort()    # 음수는 오름차순으로 해야 절댓값기준 내림차순이 된다.

# 양수
for i in range(0, len(plus), 2):
    if i + 1 == len(plus) and len(plus) % 2 == 1:
        result += plus[i]
    else:
        result += (plus[i] * plus[i + 1])

# 음수
for i in range(0, len(minus), 2):
    if i + 1 == len(minus) and len(minus) % 2 == 1:
        result += minus[i]
    else:
        result += (minus[i] * minus[i + 1])


print(result)