//  Algorithm - 최소직사각형.swift
//  Created by zhilly on 2023/07/03

import Foundation

func solution(_ sizes: [[Int]]) -> Int {
    var maxWidth: Int = 0
    var maxLength: Int = 0
    
    sizes.forEach { square in
        maxWidth = max(maxWidth, square.max()!)
        maxLength = max(maxLength, square.min()!)
    }

    return maxWidth * maxLength
}

print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))

//func solution(_ sizes: [[Int]]) -> Int {
//    var maxWidth: Int = 0
//    var maxLength: Int = 0
//
//    sizes.forEach { square in
//        var width = square[0]
//        var length = square[1]
//
//        if square[0] < square[1] {
//            width = square[1]
//            length = square[0]
//        }
//
//        if width > maxWidth {
//            maxWidth = width
//        }
//
//        if length > maxLength {
//            maxLength = length
//        }
//    }
//
//    return maxWidth * maxLength
//}
