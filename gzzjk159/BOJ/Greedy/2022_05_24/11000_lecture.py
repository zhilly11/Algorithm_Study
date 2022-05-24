import sys, heapq
input = sys.stdin.readline

n = int(input())
lecture = []

for _ in range(n):
    num = list(map(int, input().split()))
    lecture.append(num)
lecture.sort()

end = []
heapq.heappush(end, lecture[0][1])

for i in range(1,n):
    if lecture[i][0] < end[0]:
        heapq.heappush(end,lecture[i][1])
    else:
        heapq.heappop(end)
        heapq.heappush(end,lecture[i][1])
print(len(end))