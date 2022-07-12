//
//  2178_LabyrinthSearch.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/07/12.
//

import Foundation

let input = readLine()!.split(separator: " ").map {Int($0)! }
let (row,col) = (input[0],input[1])
var map = [[Int]](repeating: [Int](repeating: 0, count: col), count: row)

for i in 0..<row {
    let inputMap = readLine()!
    var cnt = 0
    for j in inputMap {
        if j == "1" {
            map[i][cnt] = 1
        } else {
            map[i][cnt] = 0
        }
        cnt += 1
    }
}

var needToVisit = [(Int,Int)]()
var distance = [[Int]](repeating: [Int](repeating: 0, count: col), count: row)
distance[0][0] = 1

func bfs(_ start:(Int,Int)) {
    needToVisit.append(start)
    map[start.0][start.1] = 0
    
    let dy = [0, 1, 0, -1]
    let dx = [1, 0, -1, 0]
    
    while !needToVisit.isEmpty {
        let node = needToVisit.removeFirst()
        
        for i in 0..<4 {
            let (nx,ny) = (node.0 + dx[i], node.1 + dy[i])
            
            // map 안에 좌표가 있고 방문 안한 경우
            if (0..<row).contains(nx) && (0..<col).contains(ny) && map[nx][ny] == 1 {
                // 좌표값을 0으로 초기화 해주고
                map[nx][ny] = 0
                needToVisit.append((nx,ny))
                //값을 누적해서 distance 배열에 넣어준다.
                distance[nx][ny] = distance[node.0][node.1] + 1
            }
        }
    }
}

bfs((0,0))

print(distance[row-1][col-1])

