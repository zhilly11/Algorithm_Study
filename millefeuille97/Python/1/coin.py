# 백준 11047번

coin_lst = []   # 코인 종류
coin_count = [] # 코인 수
N, K = map(int, input().split())    # 코인 수, 금액에 소수는 없다

for i in range(N):
    coin_lst.append(int(input()))
    coin_count.append(0)


for i in reversed(range(N)):
    coin_count[i] = K // coin_lst[i]    # 나눈 몫 = 해당 코인 수
    K = K % coin_lst[i]     # K를 남은 금액으로~

print(sum(coin_count))
print(coin_count)