# 백준 1931번

N = int(input())    # 정보 수
info = []   # 회의의 정보
count = 0   # 회의 수
next = 0    # 이전 끝시간

for i in range(N):
    start, last = map(int, input().split())
    info.append([start, last])

info = sorted(info, key=lambda x: x[0])     # 시작시간 기준으로 정렬
info = sorted(info, key=lambda x: x[1])     # 끝시간 기준으로 정렬

for s, e in info:
    if s >= next:       # 이전 끝시간보다 스타트시간이 높아야함
        count += 1
        next = e        # 끝시간 갱신

print(count)