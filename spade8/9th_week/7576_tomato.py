from collections import deque
import numpy as np
m, n = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
queue = deque()

def bfs():
    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append((i,j))
bfs()
answer = np.array(graph).flatten().tolist()

if 0 in answer:
    print("-1")
else:
    print(max(answer)-1)