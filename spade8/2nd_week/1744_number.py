import sys
input = sys.stdin.readline

seauence_num = int(input().strip())

positive = []
negative = []
result = 0
for i in range(seauence_num):
    num = int(input().strip())
    if num <= 0:
        negative.append(num)
    elif num == 1:
        result += 1
    else:
        positive.append(num)

positive.sort(reverse=True)
negative.sort()

if len(positive) % 2 ==0:
    for i in range(0,len(positive),2):
        result += positive[i] * positive[i+1]
else:
    for i in range(0,len(positive)-1,2):
        result += positive[i] * positive[i+1]
    result += positive[-1]

if len(negative) % 2 ==0:
    for i in range(0,len(negative),2):
        result += negative[i] * negative[i+1]
else:
    for i in range(0,len(negative)-1,2):
        result += negative[i] * negative[i+1]
    result += negative[-1]

print(result)