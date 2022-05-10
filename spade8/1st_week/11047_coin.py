coin_num = list(map(int, input().split()))
coin = []
result = 0
for i in range(coin_num[0]):
    coin.append(int(input()))
##데이터 입력

for i in reversed(range(coin_num[0])):
    quot, remain = divmod(coin_num[1],coin[i])
    result = result + quot
    coin_num[1] = remain
##큰 단위의 금액부터 나누어 몫은 동전의 갯수에 더하고 나머지는 계속해서 나눈다.

print(result)
##결과 출력