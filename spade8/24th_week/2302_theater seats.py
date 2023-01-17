n = int(input())
m = int(input())

vip = []
for i in range(0,m):
    k = int(input())
    vip.append(k)

dp = [1,1,2]
for i in range(3,41):
    dp.append(dp[i-2] + dp[i-1])


answer = 1
if m >= 1:
    pre = 0
    for i in range(0,m):
        answer = answer * dp[vip[i]-1-pre]
        pre = vip[i]
    answer = answer * dp[n-pre]
else:
    answer = dp[n]
print(answer)