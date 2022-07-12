import sys
input = sys.stdin.readline

import sys
sys.setrecursionlimit(10**7)
n = int(input())

answer = 0

def test_pieced(a,x,y):
    for i in range(len(a)):
        if a[i][0] == x or a[i][1] == y or abs((a[i][0] - x)/(a[i][1] - y)) == 1:
            return 0
    return True

def put_next(pieced):
    x = pieced[-1][0]
    global answer
    for i in range(x,n):
        for j in range(n):
            if test_pieced(pieced,i,j):
                pieced_cp = pieced[:]
                pieced.append([i,j])
                if len(pieced) == n:
                    answer += 1
                    return
                put_next(pieced)
                pieced = pieced_cp[:]

for i in range(n):
    chess_pieced = [[0,i]]
    put_next(chess_pieced)

print(answer)
