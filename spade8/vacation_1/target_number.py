numbers= list(map(int, input().split()))
target = int(input())

from itertools import combinations
def solution(numbers, target):
    combi_list = []
    sum_num = sum(numbers)
    target = sum_num - target

    for i in range(1, len(numbers)+1):
        combi = list(combinations(numbers, i))
        for j in combi:
            combi_list.append(sum(j)*2)

    answer = combi_list.count(target)
    return answer

print(solution(numbers,target))