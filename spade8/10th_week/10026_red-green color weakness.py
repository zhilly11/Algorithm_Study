from collections import deque
from pprint import pprint
import copy

n = int(input())
graph_normal = []
graph_weakness = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(n):
    data = input()
    graph_normal.append(list(data))
graph_weakness = copy.deepcopy(graph_normal)

def bfs(graph,x,y,color):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] == color:
                graph[nx][ny] = 0
                queue.append((nx,ny))
    return

def test_color(graph):
    cnt = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] != 0:
                bfs(graph,i,j,graph[i][j])
                cnt += 1
    print(cnt)
def make_weakness(graph):
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 'G':
                graph[i][j] ='R'

make_weakness(graph_weakness)
test_color(graph_normal)
test_color(graph_weakness)