//  Algorithm - 짝지어 제거하기.swift
//  Created by zhilly on 2023/06/26

import Foundation

// 스택을 활용
func solution(_ s: String) -> Int {
    var stack: [Character] = []
    
    for character in s {
        if !stack.isEmpty && stack.last! == character {
            stack.removeLast()
        } else {
            stack.append(character)
        }
    }
 
    return stack.isEmpty ? 1 : 0
}

// 인덱스를 활용해서 제거하는 방법으로 시도했지만
// 문제를 잘못이해해서 해맴
//func solution(_ s: String) -> Int {
//    var answer: Int = -1
//    var s = s
//    var index: Int = 0
//
//    while true {
//        if index >= s.count - 1 {
//            print("index = \(index)")
//            print("s.count - 1 = \(s.count - 1)")
//
//            break
//        }
//
//        if s[s.index(s.startIndex, offsetBy: index)] == s[s.index(s.startIndex, offsetBy: index + 1)] {
//            s.remove(at: s.index(s.startIndex, offsetBy: index + 1))
//            s.remove(at: s.index(s.startIndex, offsetBy: index))
//
//            index = 0
//
//            print(s)
//        }
//
//        index += 1
//    }
//
//    print("s = \(s)")
//
//    return answer
//}
