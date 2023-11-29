//  Algorithm - 타겟넘버.swift
//  Created by zhilly on 2023/06/09

import Foundation

func solution(_ numbers:[Int], _ target:Int) -> Int {
    var count = 0
    
    func dfs(index: Int, sum: Int) {
        if index == numbers.count {
            if sum == target {
                count += 1
            }
            
            return
        }
        
        dfs(index: index+1, sum: sum + numbers[index])
        dfs(index: index+1, sum: sum - numbers[index])
    }
    
    dfs(index: 0, sum: 0)
    
    return count
}

let numbers: [Int] = [1,1,1,1]

print(solution(numbers, 0))
