import sys
from itertools import combinations
input = sys.stdin.readline

n,s = map(int,input().split())
sequence = list(map(int, input().split()))

combi_list = []
result = 0
for i in range(1,n+1):
    combi = list(combinations(sequence,i))
    for j in combi:
        combi_list.append(sum(j))
        if sum(j) == s:
            result += 1

print(result)







