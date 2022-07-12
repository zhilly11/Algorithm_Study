//
//  1926_Picture.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/07/12.
//

import Foundation

let input = readLine()!.split(separator: " ").map {Int($0)! }
let (row,col) = (input[0],input[1])
var array = [[Int]]()

for _ in 0..<row {
    array.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

var numberOfPicture = 0
var maxSize = 0
var visited = [[Bool]](repeating: [Bool](repeating: false, count: col), count: row)

func bfs(_ start: (Int,Int)) {
    //이미 체크한 그림이면 종료
    guard visited[start.0][start.1] == false, array[start.0][start.1] == 1 else { return }
    
    numberOfPicture += 1
    let dy = [0, 1, 0, -1]
    let dx = [1, 0, -1, 0]
    var queue = [start]
    var length = 1 // 현재 그림의 길이
    
    visited[start.0][start.1] = true
    
    //queue가 비어있을 때 까지
    while !queue.isEmpty {
        let first = queue.removeFirst()
        
        // 상 하 좌 우 4번
        for i in (0..<4) {
            //다음 위치로 x,y좌표 수정
            let next = (first.0 + dy[i], first.1 + dx[i])
            
            // 벽이 아닐 때
            if next.0 < 0 || next.0 >= row || next.1 < 0 || next.1 >= col {
                continue
            }
            
            // 벽이 아니면서 아직 방문 안한곳일 때
            if array[next.0][next.1] != 0 && !visited[next.0][next.1] {
                length += 1
                array[next.0][next.1] = length
                queue.append(next)
                visited[next.0][next.1] = true
            }
        }
    }
    if length > maxSize {
        maxSize = length
    }
}

for i in 0..<row {
    for j in 0..<col {
        bfs((i,j))
    }
}

/*
for i in 0..<row {
    print(array[i])
}

print(array)*/

print(numberOfPicture)
print(maxSize)
