from collections import deque
num= int(input())
chessboard_size = []
chessboard = []
start_point = []
destination_point = []
dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]
for i in range(num):
    size = int(input())
    result = [[0 for k in range(size)] for j in range(size)]
    chessboard.append(result)
    chessboard_size.append(size)
    start_point.append(list(map(int, input().split())))
    destination_point.append(list(map(int, input().split())))


def bfs(graph,size,x,y,dest_x,dest_y):
    queue = deque()
    queue.append((x, y, 0))
    graph[y][x] = 1
    while queue:
        x, y, turn = queue.popleft()
        if x == dest_x and y == dest_y:
            return turn
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= size or ny < 0 or ny >= size:
                continue
            elif graph[ny][nx] == 0:
                graph[ny][nx] = 1
                queue.append([nx, ny, turn+1])
for i in range(num):
    print(bfs(chessboard[i],chessboard_size[i],start_point[i][0],start_point[i][1],destination_point[i][0],destination_point[i][1]))

