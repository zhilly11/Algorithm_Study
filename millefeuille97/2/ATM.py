# 백준 11399번

total = 0
N = int(input())    # 인원 수
P = list(map(int, input().split()))     # 인출에 걸리는 시간

P.sort()

for i in range(1, N+1):
    total += sum(P[:i])

print(total)
