//
//  15903_CardCobine.swift
//  CodingStudy
//
//  Created by 최지혁 on 2022/05/24.
//

import Foundation

import Foundation

let input = readLine()!.split(separator: " ").map { Int(String($0))! }
let (n, m) = (input[0],input[1])
var array = readLine()!.split(separator: " ").map { Int(String($0))! }

for _ in 0..<m {
    array.sort()
    let sum = array[0] + array[1]
    array[0] = sum
    array[1] = sum
}

print(array.reduce(0, {$0 + $1}))
