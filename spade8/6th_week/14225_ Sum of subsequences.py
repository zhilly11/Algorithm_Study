import sys
from collections import Counter
input = sys.stdin.readline
from itertools import combinations

n = int(input())
s = list(map(int, input().split()))

combi_list = []

for i in range(1,n+1):
    combi =list(combinations(s, i))
    for j in combi:
        combi_list.append(sum(j))

combi_list = list(set(combi_list))


check_num = [i for i in range(1, combi_list[-1]+2)]
combi_list = set(combi_list)
check_num = set(check_num)

answer = list(check_num - combi_list)
answer.sort()
print(answer[0])
