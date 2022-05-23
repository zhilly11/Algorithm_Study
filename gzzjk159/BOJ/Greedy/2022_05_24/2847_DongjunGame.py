import sys

input = sys.stdin.readline

n = int(input())
level = []
answer = 0

for _ in range(n):
    level.append(int(input()))

for i in range(n-2,-1,-1):
    if level[i] >= level[i+1]:
        answer += level[i]-level[i+1]+1
        level[i] = level[i+1]-1

print(answer)