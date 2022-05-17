import sys

str = sys.stdin.readline().strip()
n=""    # 문자 하나
result = 0 # 결과값
num = 0 # 숫자 하나 값
sum = 0 # +일때 숫자 합

for s in reversed(str):
    if s =="+":
        num = int(n)
        sum += num
        num = 0
        n=""
    elif s == "-":
        num = int(n)
        if sum == 0:
            result -= num
        else:
            result -= sum+num
            sum = 0
        num = 0
        n=""
    else:
        n = s+n
num = int(n)
result += num
if sum ==0:
    print(result)
else:
    result += sum
    print(result)