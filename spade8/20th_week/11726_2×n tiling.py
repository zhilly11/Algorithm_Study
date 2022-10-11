n = int(input())

s = [1, 2]
for i in range(2, n):
  s.append(s[i - 2] + s[i - 1])

print(s[n-1] % 10007)