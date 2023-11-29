//
//  1697_HideAndSeek.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/08/02.
//

import Foundation

let input = readLine()!.split(separator: " ").map{ Int($0)! }
var subin = input[0]
var target = input[1]
var queue = [(subin,0)]
var found = false
var visited = Array(repeating: 0, count: 100001)
var index = 0

// 처음부터 수빈이와 동생 위치가 같을 경우 -> 바로 종료
if subin == target {
    print(0)
} else {
    while true {
        let (now, nowCount) = queue[index]
        index += 1
        var next = 0 // 수빈이가 이동할 위치를 담을 변수
        
        for i in 0..<3 {
            if i == 0 { next = now - 1 } //x-1 이동
            else if i == 1 { next = now + 1 } // x+1 이동
            else if i == 2 { next = now * 2 } // x*2 이동
            
            if next < 0 || next > 100000 || visited[next] == 1 { continue } // 예외

            if next == target {
                found = true
                break
            } // 찾았을 경우
            
            visited[next] = 1 // 수빈이가 지나간 곳은 1로 체크 (같은 곳 재방문 방지)
            queue.append((next, nowCount + 1)) // 수빈이가 이동할 위치와 그 위치까지 가는데 걸린 시간 추가!
        }
        
        if found {
            print(nowCount+1)
            break
        }
    }
}
