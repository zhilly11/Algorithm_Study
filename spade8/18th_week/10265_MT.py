import sys

sys.setrecursionlimit(10 ** 7)
from itertools import combinations

n, k = map(int, input().split())
visited = [False] * n
max_visited = [False] * n
graph = list(map(int, input().split()))
min_cycle_list = []
min_num_cy = []
max_num_cy = []

for i in range(n):
    graph[i] -= 1


def dfs(x):
    visited[x] = True
    nx = graph[x]
    cycle.append(x)
    if visited[nx]:
        if nx in cycle:
            min_cycle_list.append(cycle[cycle.index(nx):])
            len_cyc = len(cycle[cycle.index(nx):])
            min_num_cy.append(len_cyc)
            max_num_cy.append(len_cyc)
        return
    else:
        dfs(nx)


for i in range(n):
    if not visited[i]:
        cycle = []
        dfs(i)

for i in min_cycle_list:
    for j in i:
        max_visited[j] = True

while False in max_visited:
    for i, cycle_list in enumerate(min_cycle_list):
        x = max_num_cy[i]
        for j in range(n):
            if graph[j] in cycle_list and max_visited[j] == False:
                x += 1
                cycle_list.append(j)
                max_visited[j] = True
        max_num_cy[i] = x

min_combi_list = []
max_combi_list = []
for i in range(1, len(min_num_cy) + 1):
    combi = combinations(min_num_cy, i)
    combi_max = combinations(max_num_cy, i)
    for c in combi:
        min_combi_list.append(sum(c))
    for m in combi_max:
        max_combi_list.append(sum(m))

passenger = 0
for i in range(len(min_combi_list)):
    if min_combi_list[i] <= k:
        if max_combi_list[i] >= k:
            print(k)
            break
        else:
            passenger = max(max_combi_list[i], passenger)

else:
    print(passenger)