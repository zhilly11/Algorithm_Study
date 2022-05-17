//
//  [백준] 2217.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/10.
//

import Foundation

let N = Int(readLine()!)!
var array : [Int] = Array(repeating: 0, count: N)

for i in 0..<N {
    array[i] = Int(readLine()!)!
}

array.sort(by: >)

var result = 0

for i in 0..<N {
    result = max(result, array[i] * (i+1))
}

print(result)

