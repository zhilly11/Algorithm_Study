n = int(input())

dp = [0] * (n+1)
record = [[]  for _ in range(n+1)]
record[1] = [1]
for i in range(2, n+1):
    dp[i] = dp[i-1] + 1
    temp =  record[i-1] + [i]
    if i % 3 == 0 and dp[i // 3] + 1 < dp[i]:
        dp[i] = dp[i // 3] + 1
        temp = record[i // 3] + [i]

    if i % 2 == 0 and dp[i // 2] + 1 < dp[i]:
        dp[i] = dp[i // 2] + 1
        temp = record[i // 2] + [i]

    record[i] = temp
print(dp[n])

print(*reversed(record[n]))