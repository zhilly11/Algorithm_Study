import sys

input = sys.stdin.readline

n = int(input().strip())
rope_list = []

for i in range(n):
    rope_list.append(int(input().strip()))
rope_list.sort()

result = []

for i in range(n):
    result.append(rope_list[i]*(n-i))

print(max(result))