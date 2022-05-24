# 백준 1026번

S = 0
N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A = sorted(A)
for i in range(N):
    S += A[i] * max(B)
    B.pop(B.index(max(B)))

print(S)