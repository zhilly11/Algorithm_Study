//  Algorithm - 프로세스.swift
//  Created by zhilly on 2023/06/27

import Foundation

func solution(_ priorities: [Int], _ location: Int) -> Int {
    var queue = priorities
    var location = location
    var count = 0
    
    while !queue.isEmpty {
        let first = queue.removeFirst()
        
        if !queue.isEmpty && queue.max()! > first {
            queue.append(first)
        } else {
            count += 1
            
            if location == 0 {
                break
            }
        }
        
        if location == 0 {
            location = queue.count - 1
        } else {
            location -= 1
        }
    }
    
    return count
}

print(solution([2, 1, 3, 2], 2))
