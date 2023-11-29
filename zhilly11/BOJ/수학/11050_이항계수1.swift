//  Algorithm - 11050_이항계수1.swift
//  Created by zhilly on 2023/05/19

import Foundation

let input: [Int] = readLine()!.split(separator: " ").map { Int(String($0))! }
let (n, k): (Int, Int) = (input[0], input[1])

var ret = 1

for i in 1...n {
    ret *= i
}

for i in 1...k {
    ret /= i
}

for i in 1...n-k {
    ret /= i
}

print(ret)
