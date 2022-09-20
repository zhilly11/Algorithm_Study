from collections import deque
from pprint import pprint
while True:
    l,r,c = map(int, input().split())
    if l == r == c == 0:
        break
    dx = [-1, 1, 0, 0, 0, 0]
    dy = [0, 0, -1, 1, 0, 0]
    dz = [0, 0, 0, 0, -1, 1]
    graph = []
    for i in range(l):
        floor = []
        for j in range(r):
            row = list(input())
            floor.append(row)
        input()
        graph.append(floor)


    def bfs(x, y, z):
        queue = deque()
        queue.append((x, y, z))
        graph[x][y][z] = 0
        while queue:
            x, y, z = queue.popleft()
            for i in range(6):
                nx = x + dx[i]
                ny = y + dy[i]
                nz = z + dz[i]
                if nx < 0 or nx >= l or ny < 0 or ny >= r or nz < 0 or nz >= c:
                    continue
                elif graph[nx][ny][nz] == "E":
                    return graph[x][y][z] + 1
                elif graph[nx][ny][nz] == ".":
                    graph[nx][ny][nz] = graph[x][y][z] + 1
                    queue.append((nx, ny, nz))


    for i in range(l):
        for j in range(r):
            for k in range(c):
                if graph[i][j][k] == "S":
                    result = bfs(i, j, k)
                    if result:
                        print("Escaped in %d minute(s)." % result)
                    else:
                        print("Trapped!")
