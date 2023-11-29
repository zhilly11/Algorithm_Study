//  Algorithm - 숫자게임.swift
//  Created by zhilly on 2023/07/10

import Foundation

func solution(_ a: [Int], _ b: [Int]) -> Int {
    var a = a.sort(by: >)
    var b = b.sort(by: >)
    var result: Int = 0
    
    var j = 0
    
    for i in 0..<a.count {
        if a[i] < b[j] {
            j += 1
            result += 1
        }
    }
    
    return result
}

print(solution([5,1,3,7], [2,2,6,8]))
