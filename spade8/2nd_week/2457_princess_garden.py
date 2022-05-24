import sys
input = sys.stdin.readline

flower_num = int(input().strip())
flower_list = []
for i in range(flower_num):
    a,b,c,d = map(int, input().strip().split())
    flower_list.append([a*100+b,c*100+d])


flower_list.sort(key=lambda  x: (x[0], x[1]))

last_end = 301
buf = 0
result = 0
print(flower_list)
print(flower_num)
while flower_list:
    if last_end >1130 or last_end < flower_list[0][0]:
        break
    for i in range(len(flower_list)):
        if last_end >= flower_list[0][0]:
            if buf <= flower_list[0][1]:
                buf = flower_list[0][1]
            del flower_list[0]
        else:
            break
    last_end = buf
    result += 1

if last_end < 1201:
    print(0)
else:
    print(result)

