from collections import deque
from pprint import pprint

n,k = map(int,input().split())
trace = [[False] * 500001 for _ in range(2)]

def bfs(n, k):
    q = [n]

    trace[0][n] = True
    flag = 0
    level = 0

    while q:
        if k > 500000:
            break
        if trace[flag][k]:
            return level

        tmp = []
        flag = 1 - flag
        for x in q:
            for i in (x - 1, x + 1, x * 2):
                if 0 <= i <= 500000 and not trace[flag][i]:
                    trace[flag][i] = True
                    tmp.append(i)

        level += 1
        k += level
        q = tmp

    return -1
print(bfs(n, k))