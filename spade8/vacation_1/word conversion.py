begin ="hit"
target = "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]

from collections import deque


def solution(begin, target, words):
    answer = 0
    q = deque()
    q.append([begin, 0])
    visted = [False for i in range(len(words))]

    while q:
        word, cnt = q.popleft()
        if word == target:
            answer = cnt
            break

        for i in range(len(words)):
            difference = 0
            if not visted[i]:
                for j in range(len(word)):
                    if word[j] != words[i][j]:
                        difference += 1
                if difference == 1:
                    q.append([words[i], cnt + 1])
                    visted[i] = True

    return answer

print(solution(begin,target,words))




