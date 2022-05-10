//
//  [백준] 1026.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/10.
//

import Foundation

let N = Int(readLine()!)!
var A : [Int] = Array(repeating: 0, count: N)
var B : [Int] = Array(repeating: 0, count: N)
var result = 0

A = readLine()!.split(separator: " ").map { Int(String($0))! }
B = readLine()!.split(separator: " ").map { Int(String($0))! }

A.sort()
B.sort(by: >)

for i in 0..<N {
    result += A[i] * B[i]
}

print(result)
