from collections import deque
from pprint import pprint
import copy
n, m = map(int, input().split())
graph_orgin = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = []
for i in range(n):
    graph_orgin.append(list(map(int, input())))

def bfs():
    queue = deque()
    queue.append((0,0))
    graph[0][0] = 1
    while queue:
        x,y= queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))
    return graph[n-1][m-1]

for i in range(n):
    for j in range(m):
        if graph_orgin[i][j] == 1:
            graph = copy.deepcopy(graph_orgin)
            graph[i][j] = 0
            value = bfs()
            if value:
                result.append(value)

if result:
    print(min(result))
else:
    print(-1)