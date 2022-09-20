import sys
sys.setrecursionlimit(10**7)
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


def dfs(graph,x,y,color):
    graph[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0 <= nx < n) and (0 <= ny < n):
            if graph[nx][ny] == color:
                dfs(graph,nx, ny,color)

def test_color(graph):
    cnt = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] != 0:
                dfs(graph,i,j,graph[i][j])
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