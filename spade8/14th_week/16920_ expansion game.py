from collections import deque
from pprint import pprint

n,m,p = map(int,input().split())
s = list(map(int,input().split()))
visited = [[0] *m for _ in range(n)]
q_num = []
graph = []
for i in range(n):
    data = input()
    graph.append(list(data))
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
queue = deque()

def bfs():
    while queue:
        x,y,p = queue.popleft()
        for i in range(s[p-1]):
            for j in range(4):
                nx = x + dx[j]
                ny = y + dy[j]
                if nx < 0 or nx >= n or ny < 0 or ny >= m:
                    continue
                elif graph[nx][ny] == '.':
                    graph[nx][ny] = p
                    queue.append((nx,ny,p))


for i in range(n):
    for j in range(m):
        if graph[i][j] != '.':
            num = int(graph[i][j]) -1
            graph[i][j] = num +1
            q_num.append([i,j,num+1])


q_num.sort(key=lambda x: x[2])

for i in range(len(q_num)):
    queue.append((q_num[i]))



bfs()

graph = sum(graph, [])
for i in range(1,p+1):
    print(graph.count(i),end=' ')
