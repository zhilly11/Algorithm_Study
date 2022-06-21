n = int(input())
child= list(map(int, input().split()))
#  데이터 입력
ind = [0 for _ in range(n)]
result=1
max = 1

for i in range(n):
    ind[child[i]-1] = i
# index list 구성

for i in range(n-1):
    if ind[i] < ind[i+1]:
        result += 1
        if max < result:
            max = result
    else:
        result = 1

print(n-max)
print(ind)