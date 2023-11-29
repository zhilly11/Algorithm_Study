//
//  File.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/08/09.
//

import Foundation

let cases = Int(readLine()!)!
var dx = [-2, -1, 1, 2, 2, 1, -1, -2]
var dy = [1, 2, 2, 1, -1, -2, -2, -1]
var result = [Int]()

for _ in 0..<cases {
    let n = Int(readLine()!)!
    let start = readLine()!.split(separator: " ").map({Int(String($0))!})
    let target = readLine()!.split(separator: " ").map({Int(String($0))!})
    
    // 처음부터 시작점과 목적지가 같을 경우 바로 result에 0추가
    if (start[0], start[1]) == (target[0], target[1]) {
        result.append(0)
    }
    else {
        let target_check = (target[0], target[1]) // 목적지를 튜플로 생성
        var queue = [(start[0], start[1])] // 큐 생성, 시작점을 튜플로 만들어서 넣어주기
        // 경로마다 걸린 시간을 누적해주면서 체크하기 위한 보드 배열
        var board = Array(repeating: Array(repeating: 0, count: n), count: n)
        var arrive = 0 // 목적지에 도착했는지 안했는지 체크하기 위함 (0이면 도착x)
        var index = 0
        
        while !queue.isEmpty {
            let (x, y) = queue[index]
            index += 1
            
            for i in 0..<8 {
                let dx = x + dx[i]
                let dy = y + dy[i]
               
                if dx < 0 || dy < 0 || dx >= n || dy >= n || board[dx][dy] != 0 { continue } // 예외

                board[dx][dy] = board[x][y] + 1 // 해당 자리까지 걸린 시간 누적
                
                if target_check == (dx, dy) {
                    arrive = board[dx][dy]
                    break
                } // 탐색한 자리가 목적지와 같을 경우
                
                queue.append((dx, dy)) // 아닐 경우 큐에 추가
            }
            
            if arrive != 0 { result.append(arrive); break } // arrive가 0이 아닐 경우 (목적지에 도착)
        }
    }
}

for i in result {
    print(i)
}
