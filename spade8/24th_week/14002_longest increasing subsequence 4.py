n = int(input())
a = list(map(int, input().split()))

dp = [0 for i in range(n)]
subsequence = [] #정답수열 입력할 배열선언
len_subsequence = 0
for i in range(n):
    for j in range(i):
        if a[i] > a[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1

print(dp)
len_subsequence = max(dp)  # max(dp) 값을 저장
print(len_subsequence)

for i in range(n - 1, -1, -1):
    if dp[i] == len_subsequence:
        subsequence.append(a[i])
        len_subsequence -= 1

subsequence.reverse()
print(*subsequence)

