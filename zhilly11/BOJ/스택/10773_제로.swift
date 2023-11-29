//  Algorithm - 10773_제로.swift
//  Created by zhilly on 2023/05/25

import Foundation

let n: Int = Int(readLine()!)!
var array: [Int] = []

for _ in 0..<n {
    let input: Int = Int(readLine()!)!
    
    if input == 0 {
        _ = array.popLast()
        continue
    }
    
    array.append(input)
}

print(array.reduce(0, +))
