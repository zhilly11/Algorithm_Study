from collections import deque
from pprint import pprint
m,n,k = map(int, input().split())
board = [[0]*n for _ in range(m)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
size = []
for i in range(k):
    a,b,c,d = map(int, input().split())
    for k in range(a,c):
        for j in range(b,d):
            board[j][k] = 1

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    board[x][y] = 1
    graph_vol = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            if board[nx][ny] == 0:
                board[nx][ny] = 1
                queue.append((nx,ny))
                graph_vol += 1
    return graph_vol

for i in range(m):
    for j in range(n):
        if board[i][j] == 0:
            size.append(bfs(i,j))


size.sort()
print(len(size))
for i in size:
    print(i, end =' ')