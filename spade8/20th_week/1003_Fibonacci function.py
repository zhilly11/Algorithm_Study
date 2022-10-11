T = int(input())

fibo_cnt = [[0,0]  for _ in range(40+1)]
fibo_cnt[0] = [1,0]
fibo_cnt[1] = [0,1]

for i in range(2,41):
    fibo_cnt[i] =[fibo_cnt[i-1][0] + fibo_cnt[i-2][0], fibo_cnt[i-1][1] + fibo_cnt[i-2][1]]

for _ in range(T):
    print(*fibo_cnt[int(input())])

#
#
# print(fibo_cnt)