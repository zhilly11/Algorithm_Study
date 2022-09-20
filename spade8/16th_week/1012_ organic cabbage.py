from collections import deque
from pprint import pprint

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

def dfs(info, graph,x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx < info[1]) and (0 <= ny < info[0]):
            if graph[nx][ny] == 1:
                graph[nx][ny] = -1
                dfs(info,graph,nx, ny)

def test_cabbage(info,graph):
    cnt = 0
    for i in range(info[1]):
        for j in range(info[0]):
            if graph[i][j] == 1:

                dfs(info,graph,i,j)
                cnt += 1
    print(cnt)

for i in range(t):
    test_cabbage(cabbage_info[i],cabbage_graph[i])