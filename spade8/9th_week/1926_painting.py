from collections import deque

n, m = map(int, input().split())
graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))
paint = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(graph,i,j):
    queue = deque()
    queue.append((i, j))
    graph[i][j] = 0
    graph_volumn = 1

    while queue:
        i,j = queue.popleft()
        for i in range(4):
            new_i = i + dx[i]
            new_j = j + dx[i]
            if new_i < 0 or new_i >= n or new_j < 0 or new_j >= m:
                continue
            if graph[new_i][new_j] == 1:
                graph[new_i][new_j] = 0
                queue.append((new_i, new_j))
                graph_volumn += 1
    return graph_volumn

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            paint.append(bfs(graph,i,j))

if len(paint) == 0:
    print(len(paint))
    print(0)
else:
    print(len(paint))
    print(max(paint))
print(paint)
print(graph)
