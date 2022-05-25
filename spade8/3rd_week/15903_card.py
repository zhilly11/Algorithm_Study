n = list(map(int, input().split()))
a = list(map(int, input().split()))
# 데이터 입력

for i in range(n[1]):
    a.sort()
    modify = a[0] + a[1]
    a[0] = modify
    a[1] = modify
print(sum(a))