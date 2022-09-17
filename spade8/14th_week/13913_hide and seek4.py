from collections import deque
n, k = map(int, input().split())
dx = [-1, 1]
move = [0]*100001
visted = [False for i in range(100001) ]
def path(x,t):
    trace = x
    arr = []
    for _ in range(t+1):
        arr.append(trace)
        trace = move[trace]
    print(' '.join(map(str, arr[::-1])))

def bfs(x):
    queue = deque()
    queue.append((x,0))
    while queue:
        # print(queue)
        x,time = queue.popleft()
        if x == k:
            print(time)
            path(x,time)
            return
        for i in range(3):
            if i == 2:
                nx = x * 2
            else:
                nx = x + dx[i]
            if nx < 0 or nx > 100000:
                continue
            elif visted[nx] == False:
                visted[nx] = True
                move[nx] = x
                queue.append((nx,time+1))
bfs(n)
