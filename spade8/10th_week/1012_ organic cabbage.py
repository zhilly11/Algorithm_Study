from collections import deque

t = int(input())
cabbage_info = []
cabbage_graph = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
for i in range(t):
    cabbage_info.append(list(map(int, input().split())))
    result = [[0 for k in range(cabbage_info[i][0])] for j in range(cabbage_info[i][1])]

    for j in range(cabbage_info[i][2]):
        x,y = map(int, input().split())
        result[y][x] = 1
    cabbage_graph.append(result)

def bfs(info,graph,x,y):
    queue = deque()
    queue.append((x,y))
    graph[y][x] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= info[0] or ny < 0 or ny >= info[1]:
                continue
            if graph[ny][nx] == 1:
                graph[ny][nx] = 0
                queue.append((nx,ny))
    return
def test_cabbage(info,graph):
    cnt = 0
    for i in range(info[1]):
        for j in range(info[0]):
            if graph[i][j] == 1:
                # print(j,i)
                bfs(info,graph,j,i)
                cnt += 1
    print(cnt)

for i in range(t):
    test_cabbage(cabbage_info[i],cabbage_graph[i])

