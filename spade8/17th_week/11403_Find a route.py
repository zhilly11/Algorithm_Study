import sys
from pprint import pprint
sys.setrecursionlimit(10**7)

n= int(input())
graph = []
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
for i in range(n):
    graph.append(list(map(int, input().split())))

for k in range(n):
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1 or (graph[i][k] == 1 and graph[k][j] == 1):
                graph[i][j] = 1



# for row in graph:
#     for col in row:
#         print(col, end = " ")
#     print()

for row in graph:
    print(*row)
