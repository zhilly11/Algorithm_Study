import sys

people_num = int(sys.stdin.readline())
people = list(map(int, sys.stdin.readline().split()))

result = 0
##데이터 입력
people.sort(reverse=True)

for i in range(people_num):
    result = result + (i + 1) * people[i]

print(result)