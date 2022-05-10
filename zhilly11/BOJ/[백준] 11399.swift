//
//  [백준] 11399.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/10.
//

import Foundation

let N = Int(readLine()!)!
var time : [Int] = Array(repeating: 0, count: N)

time = readLine()!.split(separator: " ").map { Int(String($0))! }

time.sort()

var result = 0

for i in 0...N {
    for j in 0..<i {
        result += time[j]
    }
}

print(result)
