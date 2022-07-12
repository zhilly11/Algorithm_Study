import sys
input = sys.stdin.readline

n = int(input().strip())
point = []

point_color = []
current_color =0
result = 0

for i in range(n):
    x,y = map(int, input().strip().split())
    point.append([x,y])

point.sort(key=lambda  x: (x[1], x[0]))

current_color = point[0][1]
point_color.append([])
for i in range(n):
    if current_color != point[i][1]:
        point_color.append([])
        current_color = point[i][1]
    point_color[point[i][1]-1].append(point[i][0])

for i in range(len(point_color)):
    for j in range(len(point_color[i])):
        if j == 0 :
            result+= point_color[i][1] - point_color[i][0]
        elif j == len(point_color[i]) -1 :
            result+= point_color[i][j] - point_color[i][j-1]
        else:
            distance_a = point_color[i][j] - point_color[i][j-1]
            distance_b = point_color[i][j+1] - point_color[i][j]
            if distance_a >= distance_b:
                result += distance_b
            else:
                result+= distance_a



print(result)
print(point_color)