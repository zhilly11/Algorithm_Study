n = int(input())
computers = []
for _ in range(n):
  computers.append(list(map(int, input())))

from collections import deque

def solution(n, computers):
    def bfs(x, graph):
        queue = deque()
        queue.append(x)
        graph[x][x] = 0
        while queue:
            x = queue.popleft()
            for i in range(0, n):
                nx = i
                if graph[x][nx] == 1:
                    visted[nx] = True
                    graph[x][nx] = 0
                    graph[nx][x] = 0
                    graph[nx][nx] = 0
                    queue.append(nx)
        return

    answer = 0
    visted = [False for i in range(n)]

    for i in range(n):
        if visted[i] == False:
            print(i)
            print(computers)
            bfs(i, computers)
            print(computers)
            answer += 1
    print(answer)
    return answer

solution(n,computers)