N, K = map(int, input().strip().split())
divisor = []
index = 0

for i in range(1, N):
    quotient, remainder = divmod(N, i)
    if index > 1 and i >= divisor[index]:
        break
    if remainder == 0:
        if quotient == i:
            divisor.insert(index, i)
        else:
            divisor.insert(index, i)
            index += 1
            divisor.insert(index, quotient)

if len(divisor) >= K:
    print(divisor[K - 1])
else:
    print(0)