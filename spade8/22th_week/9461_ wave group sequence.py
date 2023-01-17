n = int(input())

s = [1, 1, 1]
for i in range(100):
  s.append(s[i] + s[i +1])

for i in range(n):
  test = int(input())
  print(s[test-1])