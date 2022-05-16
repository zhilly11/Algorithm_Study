import sys
input = sys.stdin.readline
for _ in range(int(input())):
    n = int(input())
    data = list(map(int,input().split()))
    answer = 0
    mx = data[-1]
    for i in range(n-2,-1,-1):
        if data[i] > mx: #오늘 가격이 mx라면
            mx = data[i]
        else:
            answer += mx-data[i] #오늘 가격이 최대가 아니라면 최대-지금가격만큼 더한다
    print(answer)