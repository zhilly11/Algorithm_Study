from collections import deque
from pprint import pprint

n,m,k = map(int,input().split())
graph = [list(map(int,input().strip())) for _ in range(n)]
visited = [[[0] * (k+1) for _ in range(m)] for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    queue = deque()
    queue.append((0,0,k))
    visited[0][0][k] = 1
    while queue:
        x,y,w= queue.popleft()
        if x == n - 1 and y == m - 1:
            return visited[x][y][w]
        for i in range(5):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            # 빈공간을 갈때
            elif graph[nx][ny] == 0 and visited[nx][ny][w] == 0:
                visited[nx][ny][w] = visited[x][y][w] + 1
                queue.append((nx, ny, w))

            # 벽에 부딫혔을때
            elif graph[nx][ny] == 1 and w > 0 and visited[nx][ny][w-1] ==0:
                if visited[x][y][w] % 2 == 1:
                    visited[nx][ny][w-1] = visited[x][y][w] + 1
                    queue.append((nx, ny, w - 1))
                else:
                    visited[x][y][w] = visited[x][y][w] + 1
                    queue.append((x, y, w))
    return -1

print(bfs())

