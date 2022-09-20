n = int(input())
graph = []
global size
size = 0
size_list = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(n):
    graph.append(list(map(int, input())))

def dfs(x, y):
    global size
    graph[x][y] = 0
    size += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx < n) and (0 <= ny < n):
            if graph[nx][ny] == 1:
                dfs(nx, ny)

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            dfs(i,j)
            size_list.append(size)
            size = 0

size_list.sort()
print(len(size_list))
for i in size_list:
    print(i)