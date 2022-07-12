import sys
import math
input = sys.stdin.readline
yumi = []
people = []

min = 0
x,y = map(int, input().strip().split())
yumi = [x,y]
for i in range(3):
    x,y = map(int, input().strip().split())
    people.append([x,y])


for i in range(3):
    order = [i, i-1,i-2]
    a = ((yumi[0] - people[order[0]][0])**2 + (yumi[1] - people[order[0]][1])**2)**0.5
    b = ((people[order[0]][0] - people[order[1]][0])**2 + (people[order[0]][1] - people[order[1]][1])**2)**0.5
    c = ((people[order[1]][0] - people[order[2]][0])**2 + (people[order[1]][1] - people[order[2]][1])**2)**0.5
    sum_distance = a + b + c
    if min == 0 or min > sum_distance:
        min = sum_distance
    order = [i,i-2, i-1]
    a = ((yumi[0] - people[order[0]][0]) ** 2 + (yumi[1] - people[order[0]][1]) ** 2) ** 0.5
    b = ((people[order[0]][0] - people[order[1]][0]) ** 2 + (people[order[0]][1] - people[order[1]][1]) ** 2) ** 0.5
    c = ((people[order[1]][0] - people[order[2]][0]) ** 2 + (people[order[1]][1] - people[order[2]][1]) ** 2) ** 0.5
    sum_distance = a + b + c
    if min > sum_distance:
        min = sum_distance
print(math.trunc(min))

