from sys import stdin

n, k = map(int, stdin.readline().split())

coin_list =[]

for i in range(n):
   coin_list.append(int(stdin.readline().rstrip()))

dp = [10001] * (k+1)
print(dp)
dp[0] = 0

for coin in coin_list:
   for i in range(coin, k+1):
       dp[i] = min(dp[i],dp[i-coin]+1)
if dp[k] == 10001:
   print(-1)
else:
   print(dp[k])
