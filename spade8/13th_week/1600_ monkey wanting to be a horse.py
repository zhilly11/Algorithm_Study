from collections import deque
import copy
from pprint import pprint

k = int(input())
w, h= map(int, input().split())
dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]
hx, hy = [-2, -2, -1, 1, 2, 2, -1, 1], [-1, 1, -2, -2, -1, 1, 2, 2]

graph = []
visited = [[[0] * (k + 1) for _ in range(w)] for _ in range(h)]

for i in range(h):
    row = list(map(int, input().split()))
    graph.append(row)


def bfs():
    q = deque()
    q.append((0, 0, k))
    visit = [[[0 for i in range(31)] for i in range(w)] for i in range(h)]
    while q:
        x, y, z = q.popleft()
        if x == h - 1 and y == w - 1:
            return visit[x][y][z]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] != 1 and visit[nx][ny][z] == 0:
                visit[nx][ny][z] = visit[x][y][z] + 1
                q.append((nx, ny, z))
        if z > 0:
            for i in range(8):
                nx = x + hx[i]
                ny = y + hy[i]
                if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] != 1 and visit[nx][ny][z - 1] == 0:
                    visit[nx][ny][z - 1] = visit[x][y][z] + 1
                    q.append((nx, ny, z - 1))
    return -1

print(bfs())
