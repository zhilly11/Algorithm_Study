# 백준 1541번

exp = input().split("-")    # 식
result = 0

for i in exp[0].split("+"):
    result += int(i)

for i in exp[1:]:
    for j in i.split("+"):
        result -= int(j)

print(result)