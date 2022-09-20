from collections import deque
from pprint import pprint
n = int(input())
maze_shape = []
maze = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    maze_shape.append(list(map(int, input().split())))
    graph = []
    for j in range(maze_shape[i][1]):
        data = input()
        graph.append(data)
    maze.append(graph)

def bfs(graph,row,col):
    while q_f:
        x,y = q_f.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= row or ny < 0 or ny >= col:
                continue
            if graph[nx][ny] != '#' and not visited_f[nx][ny]:
                visited_f[nx][ny] = visited_f[x][y] + 1
                q_f.append((nx ,ny))
    while q_s:
        x, y = q_s.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= row or ny < 0 or ny >= col:
                return visited_s[x][y]
            if graph[nx][ny] != '#' and not visited_s[nx][ny]:
                if visited_s[x][y] + 1 < visited_f[nx][ny] or not visited_f[nx][ny]:
                    visited_s[nx][ny] = visited_s[x][y] + 1
                    q_s.append((nx, ny))


for i in range(n):
    graph = maze[i]
    row = maze_shape[i][1]
    col = maze_shape[i][0]
    visited_s = [[0] * col for _ in range(row)]
    visited_f = [[0] * col for _ in range(row)]
    q_s = deque()
    q_f = deque()
    for j in range(row):
        for k in range(col):
            if graph[j][k] == '@':
                q_s.append((j,k))
                visited_s[j][k] = 1
            elif graph[j][k] == "*":
                q_f.append((j,k))
                visited_f[j][k] = 1
    answer = bfs(graph,row,col)
    if answer:
        print(answer)
    else:
        print("IMPOSSIBLE")



