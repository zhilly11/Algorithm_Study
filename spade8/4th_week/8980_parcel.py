import sys
input = sys.stdin.readline

truck = list(map(int, input().split()))
n = int(input())

parcel_info= []


for i in range(n):
    parcel_info.append(list(map(int, input().split())))

parcel_info.sort(key=lambda x :x[1])

parcel = [truck[1]]*(truck[0]+1)
result = 0
for s,e,p in parcel_info:
    min_ = truck[1]
    for i in range(s,e):
        min_ = min(min_, parcel[i])
    min_ = min(min_, p)
    for i in range(s, e):
        parcel[i] -= min_
    result += min_

print(result)
