import sys

sys.setrecursionlimit(10**7)

m,n,k = map(int, input().split())
board = [[0]*n for _ in range(m)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
global size
size = 0
size_list = []
for i in range(k):
    a,b,c,d = map(int, input().split())
    for k in range(a,c):
        for j in range(b,d):
            board[j][k] = 1

def dfs(x, y):
    global size
    board[x][y] = 1
    size += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx < m) and (0 <= ny < n):
            if board[nx][ny] == 0:
                dfs(nx, ny)


for i in range(m):
    for j in range(n):
        if board[i][j] == 0:
            dfs(i, j)
            size_list.append(size)
            size = 0

size_list.sort()
print(len(size_list))
for i in size_list:
    print(i ,end =' ')