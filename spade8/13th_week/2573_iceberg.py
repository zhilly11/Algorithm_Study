from collections import deque
from pprint import pprint
n,m= map(int, input().split())

graph = []

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
day = 0
check = False
for i in range(n):
    row = list(map(int, input().split()))
    graph.append(row)

def bfs(a,b):
    queue = deque()
    queue.append((a,b))
    while queue:
        x,y = queue.popleft()
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            elif graph[nx][ny] != 0 and visited[nx][ny] == False:
                visited[nx][ny] = True
                queue.append((nx,ny))
            elif graph[nx][ny] == 0:
                count[x][y] += 1
    return 1

while True:
    visited = [[0] * m for _ in range(n)]
    count = [[0] * m for _ in range(n)]
    result = []
    for i in range(n):
        for j in range(m):
            if graph[i][j] != 0 and visited[i][j] == False:
                result.append(bfs(i, j))

    for i in range(n):
        for j in range(m):
            graph[i][j] -= count[i][j]
            if graph[i][j] < 0:
                graph[i][j] = 0

    if len(result) == 0:  # 빙산이 다없어질때까지 분리가 되지않으면 break
        break
    if len(result) >= 2:  # 빙산이 분리되면 break
        check = True
        break
    day += 1

if check:
    print(day)
else:
    print(0)


