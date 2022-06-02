s = list(input())
# 데이터 입력
strlen = len(s)


buf = ''
for i in reversed(range(strlen)):
    if buf == s[i]:
        del s[i]
    else:
        buf = s[i]

num_0 = s.count('0')
num_1 = s.count('1')

if num_0 >= num_1:
    print(num_1)
else:
    print(num_0)
