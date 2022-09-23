import sys
sys.setrecursionlimit(10**7)
import copy

n = int(input())
origin_graph = []
max_height = 0

max_area = 0
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
for i in range(n):
    row = list(map(int, input().split()))
    if max(row) > max_height:
        max_height = max(row)
    origin_graph.append(row)


def dfs(x,y,rain):
    graph[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if graph[nx][ny] > rain:
            dfs(nx,ny,rain)

for rain_height in range(max_height):
    graph = copy.deepcopy(origin_graph)
    size = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] >rain_height:
                dfs(i,j,rain_height)
                size += 1
    if max_area < size:
        max_area = size

print(max_area)