from collections import deque
n, k = map(int, input().split())
dx = [2,-1, 1]
visted = [False for i in range(100001) ]
def bfs(x):
    queue = deque()
    queue.append((x,0))
    while queue:
        # print(queue)
        x,time = queue.popleft()
        if x == k:
            return time
        for i in range(3):
            if i == 0:
                nx = x * 2
                if nx < 0 or nx > 100000:
                    continue
                elif visted[nx] == False:
                    visted[nx] = True
                    queue.append((nx, time))

            else:
                nx = x + dx[i]
                if nx < 0 or nx > 100000:
                    continue
                elif visted[nx] == False:
                    visted[nx] = True
                    queue.append((nx, time + 1))


print(bfs(n))