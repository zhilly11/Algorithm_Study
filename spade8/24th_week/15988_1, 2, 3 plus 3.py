import sys
input = sys.stdin.readline

def cal(n):
    dp = [0 for i in range(n+1)]
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for i in range(4, n+1):
        dp[i] = dp[i - 1] % 1000000009 + dp[i - 2] % 1000000009 + dp[i - 3] % 1000000009
    return dp[n]

t = int(input())
for i in range(t):
    n = int(input())
    print(cal(n) % 1000000009)