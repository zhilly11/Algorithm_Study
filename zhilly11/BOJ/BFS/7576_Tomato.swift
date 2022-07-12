//
//  7576_Tomato.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/07/12.
//

import Foundation

let input = readLine()!.split(separator: " ").map {Int(String($0))! }
let (m,n) = (input[0],input[1])
var graph = [[Int]]()

for _ in 0..<n {
    graph.append(readLine()!.split(separator: " ").map{Int(String($0))!})
}

let dy = [0, 1, 0, -1]
let dx = [1, 0, -1, 0]
var queue = [(Int,Int)]()
var empty = 0
var count = 0

func bfs() {
    var index = 0
    
    while index < queue.count {
        let (x,y) = queue[index]
        index += 1
        
        for i in 0..<4 {
            let (nx,ny) = (x + dx[i] , y + dy[i])
            
            if nx < 0 || ny < 0 || nx >= n || ny >= m { continue }
            
            if graph[nx][ny] == 0 {
                queue.append((nx,ny))
                graph[nx][ny] = graph[x][y] + 1
                count += 1
            }
        }
    }
}

for x in 0..<n {
    for y in 0..<m {
        if graph[x][y] == 1 {
            queue.append((x,y))
        } else if graph[x][y] == 0 {
            empty += 1
        }
    }
}

bfs()

if empty == 0 {
    print(0)
} else {
    if empty == count {
        print(graph.flatMap({$0}).max()!-1)
    } else {
        print(-1)
    }
}
