from collections import deque

f, s, g, u, d = map(int, input().split())
visted = [0 for i in range(f)]
dx = [u,-d]

def bfs(x):
    queue = deque()
    queue.append(x)
    visted[x] = 1
    while queue:
        x = queue.popleft()
        if x == g-1:
            return visted[x]
        for i in range(2):
            nx = x + dx[i]
            if nx < 0 or nx >= f:
                continue
            if visted[nx] == 0:
                visted[nx] = visted[x] + 1
                queue.append(nx)
result = bfs(s-1)
if result:
    print(result -1)
else:
    print("use the stairs")



