//
//  1182_Sum_Sequences.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/07/05.
//

import Foundation

func solution(index: Int, sum: Int) {
    if index == n {
        if sum == s {
            count += 1
        }
        return
    }
    
    solution(index: index+1, sum: sum + array[index])
    solution(index: index+1, sum: sum)
}


let input = readLine()!.split(separator: " ").map { Int($0)! }
let array = readLine()!.split(separator: " ").map { Int($0)! }
let (n,s) = (input[0],input[1])
var count = 0

solution(index: 0, sum: 0)

if s == 0 {
    count -= 1
}

print(count)
