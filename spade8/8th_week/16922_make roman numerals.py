n=int(input())
from itertools import combinations_with_replacement

num = [1,5,10,50]


result = []

for temp in combinations_with_replacement(range(4), n):
    sum = 0
    for i in temp:
        sum += num[i]
    result.append(sum)
print(len(set(result)))


