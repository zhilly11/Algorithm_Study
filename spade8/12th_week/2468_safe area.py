from collections import deque
import copy
from pprint import pprint
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

def bfs(x,y,rain):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] > rain:
                graph[nx][ny] = 0
                queue.append((nx,ny))

for rain_height in range(0,max_height):
    graph = copy.deepcopy(origin_graph)
    size = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] >rain_height:
                bfs(i,j,rain_height)
                size += 1
    if max_area < size:
        max_area = size

print(max_area)
