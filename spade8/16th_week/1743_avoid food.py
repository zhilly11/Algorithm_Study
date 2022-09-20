import sys
from pprint import pprint
sys.setrecursionlimit(10**7)
n, m, k = map(int, input().split())
graph = [[0] * m for _ in range(n)]
global size
size = 0
max_size = 0
for i in range(k):
    r,c = map(int, input().split())
    graph[r-1][c-1] = 1

def dfs(x, y):
    global size
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx < n) and (0 <= ny < m):
            if graph[nx][ny] == 1:
                size += 1
                graph[nx][ny] = -1
                dfs(nx, ny)

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            dfs(i,j)
            max_size = max(max_size,size)
            size = 0
print(max_size)
