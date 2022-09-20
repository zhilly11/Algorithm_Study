from collections import deque
from pprint import pprint
from collections import deque, defaultdict

n,m = map(int,input().split())
graph = defaultdict(list)
visited = [[0] * n for _ in range(n)]  # 방문 표시
lights = [[0] * n for _ in range(n)]    # 불 켠 방 표시
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(m):
    sr, sc, tr, tc = map(int, input().split())
    graph[(sr-1, sc-1)].append((tr-1, tc-1))


def bfs():
    result = 1
    visited[0][0] = 1
    lights[0][0] = 1
    q = deque([(0, 0)])
    while q:
        r, c = q.popleft()
        for tr, tc in graph[(r, c)]:
            if not lights[tr][tc]:
                lights[tr][tc] = 1
                result += 1
                for i in range(4):
                    nr = tr + dx[i]
                    nc = tc + dy[i]
                    if not (0 <= nr < n and 0 <= nc < n):
                        continue
                    if visited[nr][nc]:
                        q.append((nr, nc))

        for i in range(4):
            nr = r + dx[i]
            nc = c + dy[i]
            if not (0 <= nr < n and 0 <= nc < n):
                continue
            if not visited[nr][nc] and lights[nr][nc]:
                q.append((nr, nc))
                visited[nr][nc] = 1

    return result

print(bfs())