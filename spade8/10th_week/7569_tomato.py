from collections import deque

m, n, h = map(int, input().split())
graph = []
for i in range(h):
    floor = []
    for j in range(n):
        floor.append(list(map(int,input().split())))
    graph.append(floor)

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]
queue = deque()

def bfs():
    while queue:
        x,y,z = queue.popleft()

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]

            if nx < 0 or nx >= m or ny < 0 or ny >= n or nz < 0 or nz >= h:
                continue

            if graph[nz][ny][nx] == 0:
                graph[nz][ny][nx]  = graph[z][y][x]  + 1
                queue.append((nx, ny, nz))

for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k] == 1:
                queue.append((k,j,i))
bfs()

answer = []
for element in graph:
    answer += element
result = []
for element in answer:
    result += element

if 0 in result:
    print("-1")
else:
    print(max(result)-1)