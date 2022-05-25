# 백준 2217번

N = int(input())    # 로프 수
rope = []   # 로프 종류
result = [] # 최대 중량

for i in range(N):
    rope.append(int(input()))
rope.sort(reverse=True)

for i in range(N):
    result.append(rope[i]*(i+1))

print(max(result))
