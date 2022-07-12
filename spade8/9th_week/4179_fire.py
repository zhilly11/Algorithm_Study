from collections import deque
import copy
r,c = map(int, input().split())
graph = []
visited_j = [[0] * c for _ in range(r)]
visited_f = [[0] * c for _ in range(r)]
q_j = deque()
q_f = deque()
for i in range(r):
    data = input()
    graph.append(list(data))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():

    while q_f:
        x,y = q_f.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= r or ny < 0 or ny >= c:
                continue
            if graph[nx][ny] != '#' and not visited_f[nx][ny]:
                visited_f[nx][ny] = visited_f[x][y] + 1
                q_f.append((nx ,ny))
    while q_j:
        x, y = q_j.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= r or ny < 0 or ny >= c:
                return visited_j[x][y]
            if graph[nx][ny] != '#' and not visited_j[nx][ny]:
                if visited_j[x][y] +1 < visited_f[nx][ny] or not visited_f[nx][ny]:
                    visited_j[nx][ny] = visited_j[x][y] + 1
                    q_j.append((nx, ny))

    return "IMPOSSIBLE"

for i in range(r):
    for j in range(c):
        if graph[i][j] == "J":
            q_j.append((i,j))
            visited_j[i][j] = 1
        elif graph[i][j] == "F":
            q_f.append((i,j))
            visited_f[i][j] = 1

print(bfs())


