import sys
input = sys.stdin.readline
n,m = map(int,input().split())
sum_list = list(map(int,input().split()))


for i in range(n-1):
    sum_list[i+1] += sum_list[i]
sum_list = [0] + sum_list

for _ in range(m):
    a,b = map(int,input().split())
    print(sum_list[b]-sum_list[a-1])

