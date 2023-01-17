
import sys
input = sys.stdin.readline

n = int(input())
schedule = []
for i in range(n):
    t,p = map(int,input().strip().split())
    schedule.append([t,p])

dp = [0 for i in range(n+1)]

for i in range(n-1,-1,-1):
    if i + schedule[i][0] > n:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(schedule[i][1] + dp[i + schedule[i][0]], dp[i+1])

print(dp[0])