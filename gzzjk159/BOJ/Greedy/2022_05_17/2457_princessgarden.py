import sys
input = sys.stdin.readline

n = int(input())

fl = []
for _ in range(n):
    temp = list(map(int, input().split()))
    fl.append([temp[0]*100 + temp[1], temp[2]*100 + temp[3]])

fl.sort(key=lambda x:(x[0],x[1]))
answer = 0
end = 0
start =301
while fl:
    if start>=1201 or start<fl[0][0]:
        break
    for _ in range(len(fl)):
        if start >= fl[0][0]:
            if end <= fl[0][1]:
                end = fl[0][1]
            fl.remove(fl[0])
        else:
            break
    start = end
    answer +=1
if start < 1201:
    print(0)
else:
    print(answer)