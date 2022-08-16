from collections import deque
n, k = map(int, input().split())
dx = [-1, 1]
visted = [False for i in range(100001)]

def bfs(x):
    queue = deque()
    queue.append((x,0))
    while queue:
        x,time = queue.popleft()
        if x == k:
            return time

        for i in range(3):
            if i == 2:
                nx = x * 2
            else:
                nx = x + dx[i]
            if nx < 0 or nx > 100000:
                continue
            elif visted[nx] == False:
                visted[nx] = True
                queue.append((nx,time+1))
print(bfs(n))