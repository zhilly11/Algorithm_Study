//  Algorithm - 괄호 회전하기.swift
//  Created by zhilly on 2023/06/29

import Foundation

func solution(_ s: String) -> Int {
    var count: Int = 0
    
    for offset in 0..<s.count {
        let startIndex = s.index(s.startIndex, offsetBy: offset)
        let word = s[startIndex..<s.endIndex] + s[s.startIndex..<startIndex]
        
        if isSuccess(word: String(word)) {
            count += 1
        }
    }
    
    return count
}

func isSuccess(word: String) -> Bool {
    var queue: [Character] = []
    
    word.forEach { character in
        if queue.isEmpty {
            queue.append(character)
        } else {
            guard let last = queue.last else { continue }
            
            switch last {
            case "[":
                if character == "]" {
                    queue.removeLast()
                } else {
                    queue.append(character)
                }
            case "(":
                if character == ")" {
                    queue.removeLast()
                } else {
                    queue.append(character)
                }
            case "{":
                if character == "}" {
                    queue.removeLast()
                } else {
                    queue.append(character)
                }
            default:
                queue.append(character)
            }
        }
    }
    
    return queue.isEmpty
}
