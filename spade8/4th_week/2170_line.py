import sys
input = sys.stdin.readline

n = int(input())
line =[]

for i in range(n):
    a,b = map(int, input().strip().split())
    line.append([a,b])

# 데이터 입력
line.sort(key=lambda  x: (x[0], x[1]))
result = 0
start = line[0][0]
end = line[0][0]

for i in range(n):
    if end < line[i][1]:
        if end < line[i][0]:
            result += end - start
            start = line[i][0]
        end = line[i][1]

result += end - start
print(result)
