import sys
input = sys.stdin.readline
n = int(input())
num_list = []

for i in range(n):
    num = float(input().strip())
    num_list.append(num)

for i in range(1,n):
    num_list[i] = max(num_list[i-1]* num_list[i], num_list[i])
print(num_list)
print("%.3f" % (max(num_list)))