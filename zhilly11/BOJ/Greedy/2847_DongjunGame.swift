//
//  2847_DongjunGame.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/24.
//

import Foundation

let N = Int(readLine()!)!
var input = [Int]()
var result = 0

for _ in 0..<N {
    input.append(Int(readLine()!)!)
}

input.reverse()

for i in 0..<N - 1 {
    if input[i] <= input[i+1] {
        result += (input[i+1] - input[i]) + 1
        input[i+1] = input[i] - 1
    }
}
print(result)
