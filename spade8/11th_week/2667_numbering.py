from collections import deque
from pprint import pprint

n = int(input())
graph = []
size = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(n):
    graph.append(list(map(int, input())))

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0
    graph_vol = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx,ny))
                graph_vol += 1
    return graph_vol

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            size.append(bfs(i,j))

size.sort()
print(len(size))
for i in size:
    print(i)

