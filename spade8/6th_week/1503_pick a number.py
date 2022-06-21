import sys

input = sys.stdin.readline
n, m = map(int, input().split())
if m!= 0:
    s = list(map(int, input().split()))
else:
    s = []

min =  float('inf')
sub = 0

for i in range(1,1002):
    if i in s:
        continue
    for j in range(i,1002):
        if j in s:
            continue
        for k in range(j,1002):
            if k in s:
                continue
            sub = n - i*j*k
            if min > abs(sub):
                min = abs(sub)
            if 0> n- i * j * k:
                break

print(min)