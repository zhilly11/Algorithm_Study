//  Algorithm - 네트워크.swift
//  Created by zhilly on 2023/07/8

import Foundation

func solution(_ n: Int, _ computers: [[Int]]) -> Int {
    var visits: [Bool] = Array(repeating: false, count: n)
    var result: Int = 0
    
    func dfs(index: Int) {
        visits[index] = true
        
        for i in 0..<n {
            if computers[index][i] == 1 && !visits[i] {
                dfs(index: i)
            }
        }
    }
    
    for i in 0..<n {
        if !visits[i] {
            result += 1
            dfs(index: i)
        }
    }
    
    return result
}
