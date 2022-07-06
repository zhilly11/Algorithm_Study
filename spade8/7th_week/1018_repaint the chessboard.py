n, m = map(int, input().split())
board = []
for i in range(n):
    board.append(input())

min_distance =  float('inf')
chessboard = ["BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"]
for i in range(n - 7):
    for j in range(m - 7):
        distance = 0
        for k in range(8):
            for l in range(8):
                if chessboard[k][l]!= board[k+i][l+j]:
                    distance += 1
        min_distance = min(min_distance,distance,64-distance)


print(min_distance)




