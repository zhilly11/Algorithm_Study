//  Algorithm - 10828_스택.swift
//  Created by zhilly on 2023/05/22

import Foundation

let n: Int = Int(readLine()!)!
var stack: [Int] = []
var result: String = ""

for _ in stride(from: 0, to: n, by: 1) {
    let input: String = readLine()!
    
    switch input {
    case "pop": result += "\(stack.popLast() ?? -1)\n"
    case "size": result += "\(stack.count)\n"
    case "empty": result += "\(stack.isEmpty ? 1 : 0)\n"
    case "top": result += "\(stack.last ?? -1)\n"
    default:
        let array = input.split(separator: " ").map { Int(String($0)) ?? 0 }
        stack.append(array[1])
    }
}

print(result)
